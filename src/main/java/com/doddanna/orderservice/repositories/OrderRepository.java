package com.doddanna.orderservice.repositories;

import com.doddanna.orderservice.dtos.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDto,Long> {
}
