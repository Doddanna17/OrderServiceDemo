package com.doddanna.orderservice.external.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE/product-service/products")
public interface ProductService {

    @PutMapping("/reduce/quantity/{productId}")
    ResponseEntity<Long> reduceQuantity(@PathVariable long productId, @RequestParam long quantity);
}
