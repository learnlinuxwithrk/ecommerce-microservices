package com.ecommerce.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {


    @NotBlank(message = "Product Name can not be blank")
    private String name;

    @NotBlank(message = "Product Description can not be blank")
    private String description;

    @NotNull(message = "Product Price is required")
    @NotBlank(message = "Product price is greater then 0")
    private Double price;

    @NotNull(message = "")
    @Min(value = 0,message = "Price Quantity can not be negative")
    private Integer quantity;
}
