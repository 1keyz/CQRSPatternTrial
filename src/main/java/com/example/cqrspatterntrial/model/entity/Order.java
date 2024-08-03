package com.example.cqrspatterntrial.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elasticsearch.common.inject.AbstractModule;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cqrs_order")
public class Order extends AbstractModule {
    @Id
    private UUID id;

    private String userName;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Override
    protected void configure() {

    }
}
