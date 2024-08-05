package com.example.cqrspatterntrial.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
@Component
@RequiredArgsConstructor
public class ProducerService <T> {
    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String,Object> template;

    public void producer(T claz) {
        template.send(topic,claz);
    }
}
