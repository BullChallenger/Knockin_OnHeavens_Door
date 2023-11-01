package com.knockin.door.knockin_onheavens_door.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import com.knockin.door.knockin_onheavens_door.domain.PortFolioEntity;
import com.knockin.door.knockin_onheavens_door.domain.StockEntity;
import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import com.knockin.door.knockin_onheavens_door.dto.StockDTO.*;
import com.knockin.door.knockin_onheavens_door.dto.StockInfoDTO.*;
import com.knockin.door.knockin_onheavens_door.exception.BaseException;
import com.knockin.door.knockin_onheavens_door.repository.StockRepository;
import com.knockin.door.knockin_onheavens_door.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GetStockInfoResponseDTO getCurrentStockPrice(GetStockInfoRequestDTO dto) throws JsonProcessingException {
        String stockInfoUrl = "http://127.0.0.1:8000/stockinfo/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String dtoJson = objectMapper.writeValueAsString(dto);

        HttpEntity<String> requestJson = new HttpEntity<>(dtoJson, headers);

        ResponseEntity<String> stockInfoResponse = null;
        try {
            stockInfoResponse = restTemplate.exchange(stockInfoUrl,
                                  HttpMethod.POST,
                                  requestJson,
                                  String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        GetStockInfoResponseDTO response = objectMapper.readValue(stockInfoResponse.getBody(), GetStockInfoResponseDTO.class);
        return response;
    }

    public void buyStock(BuyStockRequestDTO dto) {
        UserEntity theUser = userRepository.findByUserId(dto.getUserId()).orElseThrow(
                () -> new EntityNotFoundException()
        );
        StockEntity theStock = stockRepository.findByStockTicker(dto.getStockTicker()).orElse(
               creatNewStockEntity(dto.getStockTicker())
        );

        // TODO: 주식 종가 가격, 수익률, 해당 주식의 수익, 구매 가격 관련 설정해둬야 함.
        PortFolioEntity thePortFolio = new PortFolioEntity(0.0, BigDecimal.TEN, dto.getStockQuantity(),
                                                            dto.getBuyPrice(), theUser, theStock);

        System.out.println(thePortFolio);
        theUser.addPortFolio(thePortFolio);
    }

    private StockEntity creatNewStockEntity(String stockTicker) {
        try {
            GetStockInfoResponseDTO response = getCurrentStockPrice(GetStockInfoRequestDTO.builder(stockTicker).build());
            log.info("createNewStockEntity : {}", response.toString());
            return StockEntity.of(response.getTicker(), response.getName(), response.getSector(), BigDecimal.valueOf(response.getCurrentPrice()));
        } catch (JsonProcessingException e) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }
    }
}
