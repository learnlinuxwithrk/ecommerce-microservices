package com.ecommerce.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ApiResponse<T> {

    private String message;
    private Boolean success;
    private T data;


}
