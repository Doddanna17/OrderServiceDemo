package com.doddanna.orderservice.external.reponse;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProductServiceResponseModel extends RuntimeException{
    private Object data;
    private String message;
    private HttpStatus status;
}
