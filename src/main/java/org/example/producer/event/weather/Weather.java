package org.example.producer.event.weather;

import java.util.Random;

public enum Weather {
    SUNNY, CLOUDY, RAIN;

    private static final Random RANDOM = new Random();

    public static Weather randomWeather() {
        Weather[] values = values();
        return values[RANDOM.nextInt(values.length)];
    }
}
