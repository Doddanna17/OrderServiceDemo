package com.doddanna.orderservice.dtos;

import com.doddanna.orderservice.enums.OrderStatus;
import com.doddanna.orderservice.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "total_amount")
    private long totalAmount;

    @Column(name = "payment_mode")
    private PaymentMode paymentMode;
    @Column(name = "order_status")
    private OrderStatus status;

    @Column(name = "ordered_on")
    private Date createdOn;
    @Column(name = "updated_on")
    private Date updatedOn;
}
