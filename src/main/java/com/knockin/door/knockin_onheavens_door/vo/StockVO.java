package com.knockin.door.knockin_onheavens_door.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class StockVO {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class  BuyStockRequestVO {

        private Long userId;

        private String stockTicker;

        private BigDecimal buyPrice;

        private Long stockQuantity;
    }

}
