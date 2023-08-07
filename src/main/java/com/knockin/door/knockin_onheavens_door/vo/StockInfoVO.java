package com.knockin.door.knockin_onheavens_door.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.knockin.door.knockin_onheavens_door.dto.StockInfoDTO.*;
import lombok.*;

public class StockInfoVO {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetStockInfoRequestVO {

        private String ticker;
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class GetStockInfoResponseVO {

        private String ticker;

        private String name;

        private int currentPrice;

        public static final GetStockInfoResponseVOBuilder builder(String ticker, String name, int currentPrice) {
            return innerBuilder()
                    .ticker(ticker)
                    .name(name)
                    .currentPrice(currentPrice);
        }

        public static final GetStockInfoResponseVO from(GetStockInfoResponseDTO dto) {
            return GetStockInfoResponseVO.builder(
                    dto.getTicker(),
                    dto.getName(),
                    dto.getCurrentPrice()
            ).build();
        }
    }
}
