import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Motorcycle extends Vehicle {
    private final boolean hasSidecar;

    protected double fuelConsumption(double acceleration) {
        return acceleration * 0.015;
    }
}