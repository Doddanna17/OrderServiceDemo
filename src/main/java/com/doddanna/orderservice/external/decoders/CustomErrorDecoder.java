package com.doddanna.orderservice.external.decoders;

import com.doddanna.orderservice.exceptions.CustomException;
import com.doddanna.orderservice.external.reponse.ProductServiceResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper=new ObjectMapper();
        log.info("::{}",response.request().url());
        log.info("::{}",response.request().headers());
        try {
            ProductServiceResponseModel badRequestException=objectMapper.readValue(response.body().asInputStream(), ProductServiceResponseModel.class);
            return new CustomException(badRequestException.getMessage(), HttpStatus.BAD_REQUEST,badRequestException.getMessage());
        } catch (IOException e) {
            return new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
