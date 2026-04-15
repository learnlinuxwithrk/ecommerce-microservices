package com.ecommerce.productservice.service.impl;

import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.exception.ResourceNotFoundException;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceiml implements ProductService {

    private  final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                            .name(productRequest.getName())
                            .description(productRequest.getDescription())
                            .price(productRequest.getPrice())
                            .quantity(productRequest.getQuantity())
                            .build();
        Product saved = productRepository.save(product);
        log.info("Creating Product: {}",productRequest.getName());
        return mapToResponse(saved);


    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Fetching All Products :{}","");
        return products.stream().map(this::mapToResponse).toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {

        Product product =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found for Id : "+id));
        log.info("Fetching Product by id: {}",id);
        return mapToResponse(product);
    }

    @Override
    public ProductResponse updateProductById(Long id, ProductRequest productRequest) {

        Product product =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Id Not Found for Update : "+id));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        Product updateProduct = productRepository.save(product);
        log.info("Updating Product for Id: {}",id);
        return mapToResponse(updateProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Id Not Found For Delete : "+id));
        log.info("Deleting Product for Id: {}",id);
        productRepository.delete(product);

    }

    private ProductResponse mapToResponse(Product product){

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
