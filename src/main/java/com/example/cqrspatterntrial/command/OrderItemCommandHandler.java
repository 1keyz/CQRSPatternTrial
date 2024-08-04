package com.example.cqrspatterntrial.command;

import com.example.cqrspatterntrial.kafka.ProducerService;
import com.example.cqrspatterntrial.model.entity.OrderItem;
import com.example.cqrspatterntrial.repository.OrderItemRepository;
import com.example.cqrspatterntrial.repository.OrderRepository;
import com.example.cqrspatterntrial.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemCommandHandler implements CommandHandler<OrderItemCommand , Void>{
    private final ProducerService producerService;
    private final OrderItemRepository repository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Void handle(OrderItemCommand command) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(orderRepository.findById(command.getOrderId()).orElseThrow());
        orderItem.setProduct(productRepository.findById(command.getProductId()).orElseThrow());
        orderItem.setQuantity(command.getQuantity());
        repository.save(orderItem);
        producerService.producer(orderItem);

        return null;
    }
}
