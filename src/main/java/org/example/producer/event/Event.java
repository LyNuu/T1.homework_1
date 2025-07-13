package org.example.producer.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.producer.event.city.City;
import org.example.producer.event.weather.Weather;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Event {
    private City city;
    private Double temperature;
    private Weather weather;
    private LocalDate date;
}
