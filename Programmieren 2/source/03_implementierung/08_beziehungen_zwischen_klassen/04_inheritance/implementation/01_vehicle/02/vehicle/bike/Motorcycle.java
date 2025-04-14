package vehicle.bike;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import vehicle.Vehicle;

@Slf4j
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Motorcycle extends Vehicle {
    private boolean hasSideCar;
    private BikeType bikeType;

    public void startEngine() {
        log.info("motorcycle engine started.");
    }

    public void wheelie() {
        log.info("performing a wheelie.");
    }
}