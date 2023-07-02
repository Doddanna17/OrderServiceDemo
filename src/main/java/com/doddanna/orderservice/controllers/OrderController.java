package com.doddanna.orderservice.controllers;

import com.doddanna.orderservice.models.OrderRequest;
import com.doddanna.orderservice.models.OrderResponse;
import com.doddanna.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest){
        Optional<OrderResponse> orderResponse = orderService.saveOrder(orderRequest);
        return new ResponseEntity<>(orderResponse.get(), HttpStatus.CREATED);
    }
}
