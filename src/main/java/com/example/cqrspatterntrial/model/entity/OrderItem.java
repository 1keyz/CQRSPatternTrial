package com.example.cqrspatterntrial.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cqrs_order1_tem")
public class OrderItem {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order1")
    private Order order;

    @OneToOne(mappedBy = "orderItem")
    private Product product;
}
