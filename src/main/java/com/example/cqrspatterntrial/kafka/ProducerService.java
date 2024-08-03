package com.example.cqrspatterntrial.kafka;

import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;
import lombok.RequiredArgsConstructor;
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
