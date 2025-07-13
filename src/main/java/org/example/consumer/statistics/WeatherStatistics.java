package org.example.consumer.statistics;

import org.example.producer.event.Event;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Component
public class WeatherStatistics {
    private static ArrayList<Event> temperatures = new ArrayList<>();

    public void addEvent(Event event) {
        temperatures.add(event);
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getHeightTemperature() {
        Optional<Event> event = temperatures.stream()
                .max(Comparator.comparing(Event::getTemperature));
        System.out.println(event.map(e -> "самая жаркая погода была " +
                        event.get().getDate() + " в городе " + event.get().getCity())
                .orElse("данных нет"));
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getLowTemperature() {
        Optional<Event> event = temperatures.stream()
                .min(Comparator.comparing(Event::getTemperature));
        System.out.println(event.map(e -> "самая низкая средняя температура в городе  " +
                        event.get().getCity())
                .orElse("данных нет"));
    }

    @Scheduled(initialDelay = 11000, fixedRate = 11000)
    public void cleanTemperatureArray() {
        temperatures.clear();
    }

}
