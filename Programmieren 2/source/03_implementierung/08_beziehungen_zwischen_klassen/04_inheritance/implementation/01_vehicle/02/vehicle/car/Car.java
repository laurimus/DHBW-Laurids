package vehicle.car;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import vehicle.Vehicle;

@Slf4j
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean isConvertible;
    private TransmissionType transmissionType;

    public void startEngine() {
        log.info("car engine started.");
    }

    public void startEngine(boolean isKeyless) {
        if (isKeyless) {
            log.info("keyless entry detected. starting car engine.");
        }
        startEngine();
    }
}