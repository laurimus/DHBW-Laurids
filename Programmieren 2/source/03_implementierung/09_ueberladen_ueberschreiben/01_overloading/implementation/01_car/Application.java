import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = Car.builder()
                .brand("BMW")
                .model("M5")
                .horsepower(600)
                .fuelType(FuelType.PETROL)
                .fuelConsumption(12.5)
                .tankCapacity(68)
                .build();

        log.info("standard range             : {} km", car.calculateRange());
        log.info("range with extra 10L       : {} km", car.calculateRange(10));
        log.info("range with refuel stops    : {} km", car.calculateRange(List.of(10.0, 15.0)));
        log.info("range with 10L in eco mode : {} km", car.calculateRange(10, true));
    }
}