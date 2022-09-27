package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.Stock;
import com.example.bigbowlxp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }
}
