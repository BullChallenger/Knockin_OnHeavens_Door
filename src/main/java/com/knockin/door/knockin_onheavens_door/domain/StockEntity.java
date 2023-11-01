package com.knockin.door.knockin_onheavens_door.domain;

import com.knockin.door.knockin_onheavens_door.constant.UserRole;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "stock")
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "stock")
@Where(clause = "is_deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockEntity extends BaseEntity {

    @Id
    @Column(name = "stock_ticker", nullable = false)
    private String stockTicker;

    @Column(name = "stock_name", nullable = false)
    private String stockName;

    @Column(name = "sector", nullable = false)
    private String sector;

    @Column(name = "market_end_price", nullable = false)
    private BigDecimal marketEndPrice;

    @OneToMany(mappedBy = "user")
    private List<PortFolioEntity> portFolioList = new ArrayList<>();

    @Builder
    public StockEntity(String stockTicker, String stockName, String sector, BigDecimal marketEndPrice) {
        this.stockTicker = stockTicker;
        this.stockName = stockName;
        this.sector = sector;
        this.marketEndPrice = marketEndPrice;
    }

    public static final StockEntity of(String stockTicker, String stockName, String sector, BigDecimal marketEndPrice) {
        return StockEntity.builder()
                .stockTicker(stockTicker)
                .stockName(stockName)
                .sector(sector)
                .marketEndPrice(marketEndPrice)
                .build();
    }

    public void updateStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public void updateStockName(String stockName) {
        this.stockName = stockName;
    }

    public void updateSector(String sector) {
        this.sector = sector;
    }

    public void updateMarketEndPrice(BigDecimal marketEndPrice) {
        this.marketEndPrice = marketEndPrice;
    }
}
