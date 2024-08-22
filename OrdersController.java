package com.sangram.stock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sangram.stock.model.Orders;
import com.sangram.stock.service.OrdersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    
    @GetMapping("orders/{userId}")
    public List<Orders> getAllOrders(@PathVariable int userId) {
        return ordersService.getAllOrders(userId);
    }

    @PostMapping("order")
    public Orders createOrder(@RequestBody Orders order) {    
        return ordersService.createOrder(order);
    }
    
}
