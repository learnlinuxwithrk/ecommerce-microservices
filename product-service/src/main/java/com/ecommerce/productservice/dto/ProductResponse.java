package com.ecommerce.productservice.dto;


import com.ecommerce.productservice.entity.Product;
import lombok.*;

@Data
@Builder
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;


}
