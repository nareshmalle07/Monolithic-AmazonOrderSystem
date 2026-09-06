package com.amazon.Order.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=ProductServiceUnavailableException.class)
    public ResponseEntity<Map<String,String>> handleProductServiceUnavailable(ProductServiceUnavailableException e){

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                            .body(Map.of("message",e.getMessage(),
                                    "status", "SERVICE_UNAVAILABLE"));
    }

}

