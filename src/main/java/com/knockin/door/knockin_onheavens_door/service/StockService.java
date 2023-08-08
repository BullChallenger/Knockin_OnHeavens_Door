package com.knockin.door.knockin_onheavens_door.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knockin.door.knockin_onheavens_door.dto.ResponseDTO;
import com.knockin.door.knockin_onheavens_door.dto.StockInfoDTO.*;
import com.knockin.door.knockin_onheavens_door.vo.StockInfoVO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GetStockInfoResponseDTO getCurrentStockPrice(GetStockInfoRequestDTO dto) throws JsonProcessingException {
        String stockInfoUrl = "http://127.0.0.1:8000/StockPriceSender";

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
}
