import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String... args) {
        Flashlight flashlight01 = new Flashlight('M',
                "UltraBright",
                (byte) 2,
                (short) 300,
                1000,
                123456789L,
                LocalDate.of(2023, 1, 1),
                LocalDateTime.now(),
                Mode.OFF,
                true,
                49.99,
                10.5f);

        Flashlight flashlight02 = new Flashlight(123456789L);

        log.info("Flashlight 01 equals Flashlight 02: {}", flashlight01.equals(flashlight02));
        log.info("Flashlight 01 and Flashlight 02 have the same hashCode: {}",
                flashlight01.hashCode() == flashlight02.hashCode());

        flashlight01.turnOn();
        flashlight01.turnOn(Mode.HIGH);

        log.info("Total battery life    : {}", Utility.formatTwoDecimals(flashlight01.calculateTotalBatteryLife()));
        log.info("Adjusted battery life : {}", Utility.formatTwoDecimals(flashlight01.calculateTotalBatteryLife(0.9f)));
    }
}