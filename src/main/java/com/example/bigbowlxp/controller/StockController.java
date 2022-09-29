package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.BowlingBooking;
import com.example.bigbowlxp.model.Stock;
import com.example.bigbowlxp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/stock")
@CrossOrigin
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @PostMapping
    public void addStock(@RequestBody Stock stock) {
        stockService.addStock(stock);
    }

    @PutMapping(path = "{id}")
    public void updateStock(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
                    String name,
            @RequestParam(required = false)
                    Integer quantity) {
        stockService.updateStock(id, name, quantity);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
    }
}
