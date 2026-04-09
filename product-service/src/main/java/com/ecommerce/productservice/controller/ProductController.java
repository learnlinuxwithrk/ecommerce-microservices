package com.ecommerce.productservice.controller;


import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }
      @GetMapping
       public List<Product> getAllProduct(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteproductById(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }

}
