package com.knockin.door.knockin_onheavens_door.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.knockin.door.knockin_onheavens_door.dto.ResponseDTO;
import com.knockin.door.knockin_onheavens_door.dto.StockDTO.*;
import com.knockin.door.knockin_onheavens_door.dto.StockInfoDTO.*;
import com.knockin.door.knockin_onheavens_door.service.StockService;
import com.knockin.door.knockin_onheavens_door.vo.StockInfoVO.*;
import com.knockin.door.knockin_onheavens_door.vo.StockVO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/stocks")
public class StockController extends AbstractController {

    private final StockService stockService;

    @PostMapping(value = "/findInfo")
    public ResponseDTO<GetStockInfoResponseVO> findCurrentPrice(@RequestBody GetStockInfoRequestVO vo) throws JsonProcessingException {
        GetStockInfoResponseDTO response = stockService.getCurrentStockPrice(GetStockInfoRequestDTO.of(vo));
        GetStockInfoResponseVO result = GetStockInfoResponseVO.from(response);
        return ResponseDTO.ok(result);
    }

    @PostMapping(value = "/buy")
    public ResponseDTO<Void> buyStock(@RequestBody BuyStockRequestVO vo) {
        stockService.buyStock(BuyStockRequestDTO.of(vo));
        return ResponseDTO.ok();
    }

}
