package com.example.cqrspatterntrial.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cqrs_product")
@Builder
public class Product {
    @Id
    private UUID id;
    private String name;
    private double price;
    @OneToOne
    private OrderItem orderItem;
}
