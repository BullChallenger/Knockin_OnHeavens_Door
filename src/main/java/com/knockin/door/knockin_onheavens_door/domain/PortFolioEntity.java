package com.knockin.door.knockin_onheavens_door.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "portfolio")
@Getter
@ToString
@DynamicInsert
@DynamicUpdate
@Table(name = "portfolio")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortFolioEntity {

    @Id
    @Column(name = "portfolio_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portFolioId;

    @Column(name = "profit_rate", nullable = false)
    private double profitRate;

    @Column(name = "profit_price", nullable = false)
    private BigDecimal profitPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Long stockQuantity;

    @Column(name = "buy_price", nullable = false)
    private BigDecimal buyPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "stock_ticker")
    private StockEntity stock;

    @Builder
    public PortFolioEntity(double profitRate, BigDecimal profitPrice, Long stockQuantity,
                           BigDecimal buyPrice, UserEntity user, StockEntity stock) {
        this.profitRate = profitRate;
        this.profitPrice = profitPrice;
        this.stockQuantity = stockQuantity;
        this.buyPrice = buyPrice;
        this.user = user;
        this.stock = stock;
    }

    public static final PortFolioEntity of(double profitRate, BigDecimal profitPrice, Long stockQuantity,
                                           BigDecimal buyPrice, UserEntity user, StockEntity stock) {
        return PortFolioEntity.builder()
                .profitRate(profitRate)
                .profitPrice(profitPrice)
                .stockQuantity(stockQuantity)
                .buyPrice(buyPrice)
                .user(user)
                .stock(stock)
                .build();
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}
