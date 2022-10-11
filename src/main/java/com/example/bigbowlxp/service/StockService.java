package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.Stock;
import com.example.bigbowlxp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Stock> getStocks(String category) {
        return stockRepository.findAllByCategory(category);
    }

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }


    @Transactional
    public void updateBeverage(Long id, Stock newStock) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalStateException("Stock with ID " + id + " does not exist."));
        System.out.println(newStock.getPrice());
        stock.setPrice(newStock.getPrice());
        stock.setName(newStock.getName());
        stock.setQuantity(newStock.getQuantity());
    }

    @Transactional
    public void updateStock(Long id, Stock newStock) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalStateException("Stock with ID " + id + " does not exist."));
        stock.setQuantity(newStock.getQuantity());
        /*
        if (stock.getName() != null
                && !Objects.equals(stock.getName(), stock.getName())
                && stock.getName().length() > 0) {
            stock.setName(stock.getName());
        }
        if (stock.getQuantity() != null
                && !Objects.equals(stock.getQuantity(), stock.getQuantity())
                && stock.getQuantity() >= 0) {
            stock.setQuantity(newStock.getQuantity());
            System.out.println(newStock.getQuantity());
        }
        */
    }

    @Transactional
    public Stock updateStockOrder(Long id,
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
        return stockRepository.save(stock);
    }


    public void deleteStock(Long id) {
        boolean exists = stockRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Stock with ID " + id + " does not exist.");
        }
        stockRepository.deleteById(id);
    }

}
