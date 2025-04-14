package vehicle;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@SuperBuilder
@ToString
public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private FuelType fuelType;

    public abstract void startEngine();

    public void startEngine(int delayInSeconds) {
        log.info("starting engine in {} seconds.", delayInSeconds);
        startEngine();
    }

    public void stopEngine() {
        log.info("engine stopped.");
    }
}