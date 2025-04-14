import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Car extends Vehicle {
    private final int seatingCapacity;
    private final double trunkVolume;

    protected double fuelConsumption(double acceleration) {
        return acceleration * 0.03;
    }
}