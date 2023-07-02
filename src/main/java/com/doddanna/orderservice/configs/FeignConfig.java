package com.doddanna.orderservice.configs;

import com.doddanna.orderservice.external.decoders.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
