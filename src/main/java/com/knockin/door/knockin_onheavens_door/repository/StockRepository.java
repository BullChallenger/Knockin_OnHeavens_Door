package com.knockin.door.knockin_onheavens_door.repository;

import com.knockin.door.knockin_onheavens_door.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, String> {

    Optional<StockEntity> findByStockTicker(String stockTicker);
}
