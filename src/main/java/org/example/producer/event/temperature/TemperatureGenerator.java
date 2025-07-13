package org.example.producer.event.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class TemperatureGenerator {
    public static Double getTemperature() {
        return BigDecimal.valueOf(new Random().nextDouble(36))
                .setScale(1, RoundingMode.HALF_DOWN)
                .doubleValue();
    }
}
