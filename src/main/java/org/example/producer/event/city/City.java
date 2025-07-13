package org.example.producer.event.city;

import java.util.Random;

public enum City {
    Магадан, Чукотка, Питер, Тюмень;

    private static final City[] VALUES = values();
    private static final Random RANDOM = new Random();
    private static final int SIZE = VALUES.length;

    public static City randomCity() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
