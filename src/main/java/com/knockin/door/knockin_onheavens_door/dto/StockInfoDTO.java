package com.knockin.door.knockin_onheavens_door.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.knockin.door.knockin_onheavens_door.vo.StockInfoVO.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class StockInfoDTO {

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static class GetStockInfoRequestDTO {

        private final String ticker;

        public static final GetStockInfoRequestDTOBuilder builder(String ticker) {
            return innerBuilder()
                    .ticker(ticker);
        }

        public static final GetStockInfoRequestDTO of(GetStockInfoRequestVO vo) {
            return StockInfoDTO.GetStockInfoRequestDTO.builder(
                    vo.getTicker()
            ).build();
        }
    }

    @Getter
    @ToString
    @Builder(builderMethodName = "innerBuilder")
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class GetStockInfoResponseDTO {

        private final String ticker;

        private final String name;

        private final int currentPrice;

        public static final GetStockInfoResponseDTOBuilder builder(String ticker, String name, int currentPrice) {
            return innerBuilder()
                    .ticker(ticker)
                    .name(name)
                    .currentPrice(currentPrice);
        }
    }
}
