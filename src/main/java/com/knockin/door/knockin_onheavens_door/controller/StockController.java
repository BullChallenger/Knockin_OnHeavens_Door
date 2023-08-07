package com.knockin.door.knockin_onheavens_door.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.knockin.door.knockin_onheavens_door.dto.ResponseDTO;
import com.knockin.door.knockin_onheavens_door.dto.StockInfoDTO.*;
import com.knockin.door.knockin_onheavens_door.service.StockService;
import com.knockin.door.knockin_onheavens_door.vo.StockInfoVO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/stocks")
public class StockController extends AbstractController {

    private final StockService stockService;

    @GetMapping(value = "/findInfo")
    public ResponseDTO<GetStockInfoResponseVO> findCurrentPrice(@RequestBody GetStockInfoRequestVO vo) throws JsonProcessingException {
        GetStockInfoResponseDTO response = stockService.getCurrentStockPrice(GetStockInfoRequestDTO.of(vo));
        GetStockInfoResponseVO result = GetStockInfoResponseVO.from(response);
        return ok(result);
    }
}
