package org.example.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.consumer.statistics.WeatherStatistics;
import org.example.producer.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class WeatherConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "weather-topic")
    public void msgListener(String msg) throws JsonProcessingException {
        WeatherStatistics.temperatures.add(objectMapper.readValue(msg, Event.class));
        System.out.println(msg);
    }
}
