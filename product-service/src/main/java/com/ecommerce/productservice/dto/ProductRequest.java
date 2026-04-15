package com.ecommerce.productservice.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name is missing")
    private String name;

    @NotBlank(message = "Product description is missing")
    private String description;

    @NotNull(message = "Product price is missing")
    @Positive(message = "Product price must be greater then 0")
    private Double price;

    @NotNull(message = "Product Quantity is missing")
    @Min(value = 0,message= "Product Quantity can not be negative")
    private Integer quantity;
}
