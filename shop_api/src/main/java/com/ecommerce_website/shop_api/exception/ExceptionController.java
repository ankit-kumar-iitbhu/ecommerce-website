package com.ecommerce_website.shop_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Object> exception(CustomException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.resolve(exception.getStatusCode()));
    }
}
