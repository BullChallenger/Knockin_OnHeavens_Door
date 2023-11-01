package com.knockin.door.knockin_onheavens_door.dto;

import com.knockin.door.knockin_onheavens_door.vo.StockVO;
import com.knockin.door.knockin_onheavens_door.vo.UserVO;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public class StockDTO {

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static class BuyStockRequestDTO {
        private final Long userId;

        private final String stockTicker;

        private final BigDecimal buyPrice;

        private final Long stockQuantity;

        public static final BuyStockRequestDTOBuilder builder(Long userId, String stockTicker, BigDecimal buyPrice, Long stockQuantity) {
            return innerBuilder()
                            .userId(userId)
                            .stockTicker(stockTicker)
                            .buyPrice(buyPrice)
                            .stockQuantity(stockQuantity);
        }

        public static final BuyStockRequestDTO of(StockVO.BuyStockRequestVO vo) {
            return BuyStockRequestDTO.builder(
                    vo.getUserId(),
                    vo.getStockTicker(),
                    vo.getBuyPrice(),
                    vo.getStockQuantity()
            ).build();
        }
    }
}
