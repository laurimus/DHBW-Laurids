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
        System.out.println("total battery life    : " + Utility.formatTwoDecimals(flashlight01.calculateTotalBatteryLife()));
        System.out.println("adjusted battery life : " + Utility.formatTwoDecimals(flashlight01.calculateTotalBatteryLife(0.9f)));
    }
}