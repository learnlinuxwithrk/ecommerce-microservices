package com.ecommerce.productservice.dto;

<<<<<<< HEAD

import jakarta.validation.constraints.*;
import lombok.*;
=======
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
>>>>>>> fe7a1cfd2243a132e1edb0e5a22988a5c1f0f09f

@Data
public class ProductRequest {

<<<<<<< HEAD
    @NotBlank(message = "Product name is missing")
    private String name;

    @NotBlank(message = "Product description is missing")
    private String description;

    @NotNull(message = "Product price is missing")
    @Positive(message = "Product price must be greater then 0")
    private Double price;

    @NotNull(message = "Product Quantity is missing")
    @Min(value = 0,message= "Product Quantity can not be negative")
=======

    @NotBlank(message = "Product Name can not be blank")
    private String name;

    @NotBlank(message = "Product Description can not be blank")
    private String description;

    @NotNull(message = "Product Price is required")
    @NotBlank(message = "Product price is greater then 0")
    private Double price;

    @NotNull(message = "")
    @Min(value = 0,message = "Price Quantity can not be negative")
>>>>>>> fe7a1cfd2243a132e1edb0e5a22988a5c1f0f09f
    private Integer quantity;
}
