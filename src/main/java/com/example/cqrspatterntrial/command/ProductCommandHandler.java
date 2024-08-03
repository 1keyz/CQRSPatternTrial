package com.example.cqrspatterntrial.command;

import com.example.cqrspatterntrial.model.dto.CreateProductCommand;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.repository.ProductRepository;
import com.example.cqrspatterntrial.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCommandHandler implements CommandHandler<CreateProductCommand,Void>{
    private final ProductRepository repository;
    private final ProducerService producerService;

    @Override
    public Void handle(CreateProductCommand command) {
        Product product = new Product(UUID.randomUUID(),command.getName(),command.getPrice());
        repository.save(product);
        producerService.producer(product);
        return null;
    }
}
