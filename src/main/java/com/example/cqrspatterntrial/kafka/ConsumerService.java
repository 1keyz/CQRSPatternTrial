package com.example.cqrspatterntrial.kafka;


import com.example.cqrspatterntrial.model.entity.*;
import com.example.cqrspatterntrial.repository.OrderESRepository;
import com.example.cqrspatterntrial.repository.OrderItemESRepository;
import com.example.cqrspatterntrial.repository.ProductESRepository;
import com.example.cqrspatterntrial.repository.UserESRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerService {
    private final ProductESRepository productESRepository;
    private final OrderItemESRepository orderItemESRepository;
    private final OrderESRepository orderESRepository;
    private final UserESRepository userESRepository;

    @KafkaListener(topics = "${kafka.topic}" , groupId = "notification-group")
    public void consume(ConsumerRecord<String,Object> record) {
        Object obj = record.value();

        if (obj instanceof Product) {
            Product product = (Product) obj;
            ProductES productES = new ProductES(product.getId(), product.getName(), product.getPrice());
            productESRepository.save(productES);
        } else if (obj instanceof OrderItem) {
            OrderItem orderItem = (OrderItem) obj;
            OrderItemES orderItemES = new OrderItemES(orderItem.getId(),orderItem.getOrder(),orderItem.getProduct(),orderItem.getQuantity());
            orderItemESRepository.save(orderItemES);
        } else if (obj instanceof Order) {
            Order order =(Order) obj;
            OrderES orderES = new OrderES(order.getId(),order.getUser(),order.getOrderItems());
            orderESRepository.save(orderES);
        }else {
            User user = (User) obj;
            UserES userES = new UserES(user.getId(), user.getName(), user.getOrderList());
            userESRepository.save(userES);
        }
    }


}
