package com.example.cqrspatterntrial.service;

import com.example.cqrspatterntrial.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
@Component
@RequiredArgsConstructor
public class ProducerService {
    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String,Object> template;

    public void producer(Product product) {
        template.send(topic,product);
    }
}
