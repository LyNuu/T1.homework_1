package org.example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.producer.event.Event;
import org.example.producer.event.city.City;
import org.example.producer.event.temperature.TemperatureGenerator;
import org.example.producer.event.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class WeatherProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(initialDelay = 2000, fixedRate = 2200)
    public void sendMessage() throws JsonProcessingException {
        String event = objectMapper.writeValueAsString(Event.builder()
                .city(City.randomCity())
                .date(LocalDate.now())
                .weather(Weather.randomWeather())
                .temperature(TemperatureGenerator.getTemperature())
                .build());
        kafkaTemplate.send("weather-topic", event);
    }
}
