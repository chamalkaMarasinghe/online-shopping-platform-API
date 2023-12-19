package com.onlineShoppingAPI.orderService.controller;

import com.onlineShoppingAPI.orderService.dto.OrderRequest;
import com.onlineShoppingAPI.orderService.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "toInventory", fallbackMethod = "fallbackMethodOfCreateOrder")
    public String createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
        return "Order created successfully!";
    }

    public String fallbackMethodOfCreateOrder(OrderRequest orderRequest, RuntimeException runtimeException){
        return runtimeException.getMessage();
    }
}
