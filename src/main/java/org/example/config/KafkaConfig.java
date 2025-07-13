package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("weather-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
