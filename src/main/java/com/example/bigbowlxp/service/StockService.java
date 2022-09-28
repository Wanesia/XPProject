package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.Stock;
import com.example.bigbowlxp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateStock(Long id,
                            String name,
                            Integer quantity) {
        Stock stock = stockRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Stock with ID " + id + " does not exist."));
        if (name != null
                && !Objects.equals(stock.getName(), name)
                && name.length() > 0) {
            stock.setName(name);
        }
        if (quantity != null
                && !Objects.equals(stock.getQuantity(), quantity)
                && quantity >= 0) {
            stock.setQuantity(quantity);
        }
    }

    public void deleteStock(Long id) {
        boolean exists = stockRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Stock with ID " + id + " does not exist.");
        }
        stockRepository.deleteById(id);
    }
}
