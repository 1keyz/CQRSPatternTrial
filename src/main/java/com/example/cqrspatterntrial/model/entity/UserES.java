package com.example.cqrspatterntrial.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "users")
public class UserES {
    @Id
    private UUID id;
    private String name;
    private List<Order> orderList;
}
