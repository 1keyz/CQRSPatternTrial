package com.example.cqrspatterntrial.model.entity;

import com.example.cqrspatterntrial.model.entity.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cqrsUser")
@Builder
public class User {
    @Id
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
}
