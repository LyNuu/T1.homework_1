package org.example.producer.event.city;

import java.util.Random;

public enum City {
    Магадан, Чукотка, Питер, Тюмень;

    private static final Random RANDOM = new Random();

    public static City randomCity() {
        City[] values = values();
        return values[RANDOM.nextInt(values.length)];
    }
}
