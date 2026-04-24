package com.ecommerce.order_service.controller;


import com.ecommerce.order_service.dto.ApiResponse;
import com.ecommerce.order_service.dto.ProductResponse;
import com.ecommerce.order_service.entities.Order;
import com.ecommerce.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

     private final OrderService orderService;

             @PostMapping
              public ResponseEntity<ApiResponse<Order>>createOrder(@RequestParam Long productId, @RequestParam Integer quantity){

                      Order order = orderService.createOrder(productId,quantity);

                    return ResponseEntity.status(HttpStatus.CREATED).
                            body(ApiResponse.<Order>builder()
                                    .success(true)
                                    .data(order)
                                    .message("Order Successfully Created")
                                    .build());


              }
}
