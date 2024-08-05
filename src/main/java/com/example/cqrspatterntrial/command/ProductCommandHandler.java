package com.example.cqrspatterntrial.command;


import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.repository.ProductRepository;
import com.example.cqrspatterntrial.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCommandHandler implements CommandHandler<ProductCommand,Void>{
    private final ProductRepository repository;
    private final ProducerService producerService;

    @Override
    public Void handle(ProductCommand command) {
        Product product =Product.builder()
                .id(UUID.randomUUID())
                .price(command.getPrice())
                .name(command.getName())
                .build();
        repository.save(product);
        producerService.producer(product);
        return null;
    }
}
