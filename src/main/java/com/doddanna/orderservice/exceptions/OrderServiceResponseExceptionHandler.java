package com.doddanna.orderservice.exceptions;

import com.doddanna.orderservice.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderServiceResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<ResponseModel> feignServiceErrorHandling(CustomException exception){
        return new ResponseEntity<>(ResponseModel
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ResponseModel> globalExceptionHandling(Exception exception){
        return new ResponseEntity<>(ResponseModel
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
