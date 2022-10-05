package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.BowlingBooking;
import com.example.bigbowlxp.model.Stock;
import com.example.bigbowlxp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
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
    public List<Stock> getStocks(@RequestParam (required = false) String category) {
        if (category != null && !category.isEmpty() && !category.equals("All")){
            System.out.println("Category was called");
            return stockService.getStocks(category);
        }
        System.out.println("Non category was called");
        return stockService.getStocks();
    }

    @PostMapping
    public void addStock(@RequestBody Stock stock) {
        stockService.addStock(stock);
    }

    @PutMapping(path = "{id}", consumes={MediaType.APPLICATION_JSON_VALUE})
    public void updateStock(
            @PathVariable("id") Long id,
            @RequestBody Stock stock) {
        System.out.println("jjj");
        stockService.updateStock(id, stock);
    }

    //get the id of stock and pass in the url
    @PutMapping(path = "{id}")
    public Stock updateStockOrder(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
            String name,
            @RequestParam(required = false)
            Integer quantity) {
        System.out.println("Id:" + id + name + quantity);
        return stockService.updateStockOrder(id, name, quantity);
    }



    @DeleteMapping(path = "{id}")
    public void deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
    }
}
