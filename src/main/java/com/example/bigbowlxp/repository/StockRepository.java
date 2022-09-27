package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
