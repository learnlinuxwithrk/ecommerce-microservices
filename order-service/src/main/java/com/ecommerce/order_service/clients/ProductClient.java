package com.ecommerce.order_service.clients;


import com.ecommerce.order_service.dto.ApiResponse;
import com.ecommerce.order_service.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductClient {

            @GetMapping("/api/products/{id}")
            ApiResponse<ProductResponse> getProductById(@PathVariable Long id);
}
