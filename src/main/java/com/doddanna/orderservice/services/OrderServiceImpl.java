package com.doddanna.orderservice.services;

import com.doddanna.orderservice.dtos.OrderDto;
import com.doddanna.orderservice.enums.OrderStatus;
import com.doddanna.orderservice.external.clients.ProductService;
import com.doddanna.orderservice.models.OrderRequest;
import com.doddanna.orderservice.models.OrderResponse;
import com.doddanna.orderservice.repositories.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Optional<OrderResponse> saveOrder(OrderRequest orderRequest){
        log.info("Saving the orders");
        //Validate orders w.r.t inputs;
        //Reduce the product quantity;
        //Save the product with created-status;
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderRequest,orderDto);
        orderDto.setCreatedOn(new Date());
        orderDto.setUpdatedOn(new Date());
        orderDto.setStatus(OrderStatus.CREATED);
        OrderDto save = orderRepository.save(orderDto);
        log.info("Order saved");
        return Optional.of(OrderResponse.builder().id(save.getId()).build());
    }
}
