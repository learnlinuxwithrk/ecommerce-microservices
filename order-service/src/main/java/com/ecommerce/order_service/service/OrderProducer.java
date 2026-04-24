package com.ecommerce.order_service.service;

import com.ecommerce.order_service.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendOrderEvent(OrderEvent event){

        System.out.println("Order Created Sending Event "+event);
        kafkaTemplate.send("order-topic",event);
    }

}
