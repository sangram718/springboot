package com.sangram.stock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sangram.stock.dto.WatchlistDTO;
import com.sangram.stock.model.Watchlist;
import com.sangram.stock.service.WatchlistService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @GetMapping("watchlist/{userId}")
    public List<Watchlist> getAllWatchlists(@PathVariable int userId){
       return watchlistService.getAllWatchlists(userId);
    }

    @PostMapping("watchlist")
    public Watchlist addWatchlist(@RequestBody WatchlistDTO watchlistDTO){

        return watchlistService.addWatchlist(watchlistDTO);
    }

    @DeleteMapping("watchlist/{id}")
    public String deleteWatchlist(@PathVariable int id){

        watchlistService.deleteWatchlist(id);
        return "Succesfully removed";
    }
    
    
}
