package com.example.cqrspatterntrial.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "order_items")
public class OrderItemES {
    @Id
    private UUID id;

    private Order order;

    private Product product;

    private double quantity;
}
