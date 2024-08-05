package com.example.cqrspatterntrial.command;

import com.example.cqrspatterntrial.model.entity.Order;
import com.example.cqrspatterntrial.model.entity.OrderItem;
import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.User;
import com.example.cqrspatterntrial.repository.OrderItemRepository;
import com.example.cqrspatterntrial.repository.OrderRepository;
import com.example.cqrspatterntrial.repository.ProductRepository;
import com.example.cqrspatterntrial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderCommandHandler implements CommandHandler<OrderCommand, Void>{

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;


    @Override
    public Void handle(OrderCommand command) {
       User user = userRepository.findById(command.getUserId()).orElseThrow();

       Order order = new Order();
       order.setId(command.getId() != null ? command.getId() : UUID.randomUUID());
       order.setUser(user);

       Order savedOrder = orderRepository.save(order);

       List<OrderItem> orderItems = command.getOrderItems().stream()
               .map(itemCommand -> {
                   Product product = productRepository.findById(itemCommand.getProductId()).orElseThrow();

                   OrderItem orderItem = new OrderItem();
                   orderItem.setId(itemCommand.getId() != null ? itemCommand.getId() : UUID.randomUUID());
                   orderItem.setProduct(product);
                   orderItem.setQuantity(itemCommand.getQuantity());
                   orderItem.setOrder(savedOrder);

                   return orderItem;
               })
               .collect(Collectors.toList());
       orderItemRepository.saveAll(orderItems);

       return null;
    }
}
