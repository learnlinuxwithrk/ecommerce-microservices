package com.ecommerce.order_service.entities;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "orders")
public class Order {

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;

         private Long productId;

         private Integer quantity;

         private Double totalPrice;
}
