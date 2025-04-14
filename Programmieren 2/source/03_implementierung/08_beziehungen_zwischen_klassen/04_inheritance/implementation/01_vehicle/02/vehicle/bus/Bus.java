package vehicle.bus;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import vehicle.Vehicle;

@Slf4j
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Bus extends Vehicle {
    private int passengerCapacity;
    private boolean isDoubleDecker;
    private String routeNumber;

    public void startEngine() {
        log.info("bus engine started. ready to transport passengers.");
    }

    public void announceRoute() {
        log.info("this bus is on route: {}", routeNumber);
    }
}