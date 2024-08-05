package com.example.cqrspatterntrial.command;

import com.example.cqrspatterntrial.kafka.ProducerService;
import com.example.cqrspatterntrial.model.entity.Order;
import com.example.cqrspatterntrial.model.entity.OrderItem;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.repository.OrderItemRepository;
import com.example.cqrspatterntrial.repository.OrderRepository;
import com.example.cqrspatterntrial.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemCommandHandler implements CommandHandler<OrderItemCommand , Void>{
    private final ProducerService producerService;
    private final OrderItemRepository repository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Void handle(OrderItemCommand command) {
        Order order = orderRepository.findById(command.getOrderId()).orElseThrow();

        Product product = productRepository.findById(command.getProductId()).orElseThrow();

        OrderItem orderItem = new OrderItem();
        orderItem.setId(command.getId() != null ? command.getId() : UUID.randomUUID());
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(command.getQuantity());
        repository.save(orderItem);
        producerService.producer(orderItem);

        return null;
    }
}
