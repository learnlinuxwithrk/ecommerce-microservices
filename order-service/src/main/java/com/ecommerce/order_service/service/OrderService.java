package com.ecommerce.order_service.service;

import com.ecommerce.order_service.clients.ProductClient;
import com.ecommerce.order_service.dto.ApiResponse;
import com.ecommerce.order_service.dto.ProductResponse;
import com.ecommerce.order_service.entities.Order;
import com.ecommerce.order_service.event.OrderEvent;
import com.ecommerce.order_service.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final  ProductClient productClient;

    private final OrderRepository orderRepository;

    private final OrderProducer orderProducer;

    @CircuitBreaker(name="productService",fallbackMethod = "fallbackCreateOrder")
    public Order createOrder(Long productId, Integer quantity){

        ApiResponse<ProductResponse> response =
                productClient.getProductById(productId);

        ProductResponse product =   response.getData();

        double total = product.getPrice() * quantity;

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(total);

         Order newOrder =  orderRepository.save(order);
         //Publish Event
        OrderEvent orderEvent = new OrderEvent(newOrder.getId(),newOrder.getProductId(),newOrder.getQuantity());

        orderProducer.sendOrderEvent(orderEvent);

         return newOrder;

    }


    // 🔥 Fallback method
    public Order fallbackCreateOrder(Long productId, Integer quantity, Exception ex){

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(0.0); // fallback price

        return order;
    }
}
