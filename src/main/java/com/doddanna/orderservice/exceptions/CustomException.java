package com.doddanna.orderservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException{
    private HttpStatus status;
    private String message;
    private String errorCode;

    public CustomException(String message, HttpStatus status, String errorCode) {
        super(message);
        this.status = status;
        this.message=message;
        this.errorCode = errorCode;
    }
}
