package com.example.cqrspatterntrial.kafka;


import com.example.cqrspatterntrial.model.entity.Product;
import com.example.cqrspatterntrial.model.entity.ProductES;
import com.example.cqrspatterntrial.repository.ProductESRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerService {
    private final ProductESRepository productESRepository;

    @KafkaListener(topics = "${kafka.topic}" , groupId = "notification-group")
    public void consume(ConsumerRecord<String,Object> record) {
        Object obj = record.value();

        if (obj instanceof Product) {
            Product product = (Product) obj;
            ProductES productES = new ProductES(product.getId(), product.getName(), product.getPrice());
            productESRepository.save(productES);
        }
    }


}
