package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ApiResponse;
import com.ecommerce.productservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

//
//    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
//
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Objects> handleResourceNotFoundException(ResourceNotFoundException ex){

        return ApiResponse.<Objects>builder()
                .success(false)
                .message(ex.getMessage())
                .data(null)
                .build();

    }

}
