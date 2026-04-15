package com.ecommerce.productservice.controller;


import com.ecommerce.productservice.dto.ApiResponse;
import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest productRequest){

        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<ProductResponse>builder()
                .success(true)
                .message("Product Created Successfully")
                .data(productResponse)
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProduct(){

         List<ProductResponse> products = productService.getAllProducts();
         return ResponseEntity.ok(ApiResponse
                 .<List<ProductResponse>>builder()
                 .success(true)
                 .message("Product fetched Successfully")
                 .data(products)
                 .build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductbyId(@Valid @PathVariable Long id){

        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(ApiResponse.<ProductResponse>builder()
                .data(productResponse)
                .success(true)
                .message("Product Fetched Successfully for id "+id).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProductById(@PathVariable Long id,@Valid @RequestBody ProductRequest productRequest){

        ProductResponse updatedProduct = productService.updateProductById(id,productRequest);


        return ResponseEntity.ok(ApiResponse.<ProductResponse>builder()
                .data(updatedProduct)
                .success(true)
                .message("Product Successfully Updated for ID "+id).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> deleteproductById(@Valid @PathVariable Long id){
        ProductResponse productResponse = productService.getProductById(id);
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<ProductResponse>builder()
                        .success(true)
                        .message("Product Successfully Deleted")
                        .data(productResponse)
                        .build()
        );
    }
}
