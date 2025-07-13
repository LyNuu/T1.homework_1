package org.example.producer.event.weather;

import java.util.Random;

public enum Weather {
    SUNNY, CLOUDY, RAIN;

    private static final Weather[] VALUES = values();
    private static final Random RANDOM = new Random();
    private static final int SIZE = VALUES.length;

    public static Weather randomWeather() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
