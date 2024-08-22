package com.sangram.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sangram.stock.model.Stocks;
import com.sangram.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public List<Stocks> getAllStock(){
        return stockService.getAllStocks();
    }

    @GetMapping("stocks")
    public List<Stocks> getAllStocks(){
        return stockService.getAllStocks();
    }
    @PostMapping("stock")
    public Stocks addStock(@RequestBody Stocks stock){
        return (Stocks) stockService.addStock(stock);
    }

    @GetMapping("stock/{stockCode}")
    public List<Stocks> findStockByStockCode(@PathVariable String stockCode){
        return stockService.findStockByStockCode(stockCode);
    }
    
}
