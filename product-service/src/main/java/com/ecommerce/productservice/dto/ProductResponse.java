package com.ecommerce.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;
}
