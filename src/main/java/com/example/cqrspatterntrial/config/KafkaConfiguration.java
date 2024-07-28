package com.example.cqrspatterntrial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic topicExample() {
        return TopicBuilder.name("cqrs-topic-1")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
