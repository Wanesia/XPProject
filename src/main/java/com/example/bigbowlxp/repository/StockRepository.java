package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAllByCategory(String category);
}
