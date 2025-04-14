import java.time.LocalDate;
import java.time.LocalDateTime;

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

        System.out.println(flashlight01.equals(flashlight02));
        System.out.println(flashlight01.hashCode() == flashlight02.hashCode());

        flashlight01.turnOn();
        flashlight01.turnOn(Mode.HIGH);
        System.out.println("Total battery life: " + flashlight01.calculateTotalBatteryLife());
        System.out.println("Adjusted battery life: " + flashlight01.calculateTotalBatteryLife(0.9f));

        System.out.println("Is bright enough for 800 lumens? " + flashlight01.isBrightEnough(800));
        System.out.println("Is bright enough for 800 lumens with 100 safety margin? " + flashlight01.isBrightEnough(800,
                100));

        System.out.println("Total weight with 50g batteries: " + flashlight01.calculateTotalWeight((short) 50));
        System.out.println("Total weight with 50g batteries and 100g accessories: " + flashlight01.calculateTotalWeight(
                (short) 50,
                (short) 100));

        System.out.println("Is under warranty? " + flashlight01.isUnderWarranty(LocalDate.now(), 2));
        System.out.println("Is under warranty with 30-day grace period? " + flashlight01.isUnderWarranty(LocalDate.now(),
                2,
                30));

        flashlight01.displayDetails();
        flashlight01.displayDetails(true);
    }
}