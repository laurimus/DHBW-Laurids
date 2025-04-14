import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String... args) {
        // 1:1 unidirectional association
        Manufacturer manufacturer = new Manufacturer("BrightCo", "USA");

        Flashlight flashlight = new Flashlight('M',
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
                10.5f,
                manufacturer);

        flashlight.setBatteryLifeInHours(15000);
        flashlight.turnOn();
        flashlight.turnOff();
        log.info("---");

        flashlight.turnOn(Mode.HIGH);
        flashlight.turnOff();
    }
}