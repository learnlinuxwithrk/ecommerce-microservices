package com.ecommerce.productservice.dto;

<<<<<<< HEAD

import com.ecommerce.productservice.entity.Product;
import lombok.*;

@Data
@Builder
=======
import lombok.Builder;
import lombok.Data;

@Builder
@Data
>>>>>>> fe7a1cfd2243a132e1edb0e5a22988a5c1f0f09f
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;
<<<<<<< HEAD


=======
>>>>>>> fe7a1cfd2243a132e1edb0e5a22988a5c1f0f09f
}
