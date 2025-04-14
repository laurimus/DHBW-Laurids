package vehicle.truck;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import vehicle.Vehicle;

@Slf4j
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Truck extends Vehicle {
    private double cargoCapacity;
    private boolean is4x4;
    private String cargoType;

    public void startEngine() {
        log.info("truck engine started. ready to haul cargo.");
    }

    public void loadCargo(String cargo) {
        log.info("Loading {} into the truck.", cargo);
    }
}