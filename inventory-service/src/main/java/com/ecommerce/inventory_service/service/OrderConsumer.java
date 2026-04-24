package com.ecommerce.inventory_service.service;

import com.ecommerce.inventory_service.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {


             @KafkaListener(topics="order-topic",groupId = "inventory-group")
             public void consume(OrderEvent event){
                 System.out.println("Received Order Event "+event);

             }
}
