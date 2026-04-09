package com.ecommerce.productservice.service;

import com.ecommerce.productservice.entity.Product;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProductById(Long id,Product product);

    void deleteProduct(Long id);
}
