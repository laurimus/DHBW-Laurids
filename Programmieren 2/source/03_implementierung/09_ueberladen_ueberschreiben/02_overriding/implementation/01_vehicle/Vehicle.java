import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Vehicle {
    private final String make;
    private final String model;
    private final int year;
    private final double weight;
    private final double maximumSpeed;
    private final double fuelCapacity;
    private double currentSpeed;
    private double fuelLevel;

    public void accelerate(double powerFactor) {
        if (fuelLevel > 0) {
            double acceleration = (maximumSpeed / weight) * powerFactor;
            currentSpeed = Math.min(currentSpeed + acceleration, maximumSpeed);
            fuelLevel = Math.max(fuelLevel - fuelConsumption(acceleration), 0);
        }
    }

    public void brake(double force) {
        currentSpeed = Math.max(currentSpeed - (force * 0.1 * weight), 0);
    }

    public void refuel(double liters) {
        fuelLevel = Math.min(fuelLevel + liters, fuelCapacity);
    }

    protected abstract double fuelConsumption(double acceleration);
}