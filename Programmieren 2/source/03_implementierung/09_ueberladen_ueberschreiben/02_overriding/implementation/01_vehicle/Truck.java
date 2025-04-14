import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Truck extends Vehicle {
    private final double cargoCapacity;
    private final int axles;

    protected double fuelConsumption(double acceleration) {
        return acceleration * 0.08;
    }
}