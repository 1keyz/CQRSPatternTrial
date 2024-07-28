package com.example.cqrspatterntrial.service;


import com.example.cqrspatterntrial.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConsumerService {
    private final InMemoryDb db;

    @KafkaListener(topics = "${kafka.topic}" , groupId = "notification-group")
    public void consume(ConsumerRecord<String,String> record) {
        Object obj = record.value();

        if (obj instanceof Product) {
            Product product = (Product) obj;
            db.save(product);
        }
    }


}
