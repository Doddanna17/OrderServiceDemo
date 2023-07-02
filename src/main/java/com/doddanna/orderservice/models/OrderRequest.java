package com.doddanna.orderservice.models;

import com.doddanna.orderservice.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private long productId;
    private long userId;
    private long quantity;
    private long totalAmount;
    private PaymentMode paymentMode;
}
