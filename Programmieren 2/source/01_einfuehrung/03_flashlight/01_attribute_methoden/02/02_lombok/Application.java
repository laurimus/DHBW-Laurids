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

        log.info("Flashlights are equal: {}", flashlight01.equals(flashlight02));
        log.info("Flashlights hash codes are equal: {}", flashlight01.hashCode() == flashlight02.hashCode());

        flashlight01.turnOn();
        flashlight01.turnOn(Mode.HIGH);

        log.info("Total battery life: {}", flashlight01.calculateTotalBatteryLife());
        log.info("Adjusted battery life: {}", flashlight01.calculateTotalBatteryLife(0.9f));

        log.info("Is bright enough for 800 lumens? {}", flashlight01.isBrightEnough(800));
        log.info("Is bright enough for 800 lumens with 100 safety margin? {}", flashlight01.isBrightEnough(800, 100));

        log.info("Total weight with 50g batteries: {}", flashlight01.calculateTotalWeight((short) 50));
        log.info("Total weight with 50g batteries and 100g accessories: {}", flashlight01.calculateTotalWeight((short) 50, (short) 100));

        log.info("Is under warranty? {}", flashlight01.isUnderWarranty(LocalDate.now(), 2));
        log.info("Is under warranty with 30-day grace period? {}", flashlight01.isUnderWarranty(LocalDate.now(), 2, 30));

        flashlight01.displayDetails();
        flashlight01.displayDetails(true);
    }
}