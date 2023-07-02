package com.doddanna.orderservice.services;

import com.doddanna.orderservice.dtos.OrderDto;
import com.doddanna.orderservice.models.OrderRequest;
import com.doddanna.orderservice.models.OrderResponse;
import com.doddanna.orderservice.repositories.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface OrderService {
    public Optional<OrderResponse> saveOrder(OrderRequest orderRequest);

}
