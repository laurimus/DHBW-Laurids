import lombok.ToString;

import java.util.UUID;

@ToString(callSuper = true)
public abstract class Vehicle {
    protected final String serialNumber;
    protected final String brand;
    protected final int numberOfDoors;
    protected final int numberOfSeats;
    protected final int numberOfWheels;

    public Vehicle(String brand, final int numberOfDoors, final int numberOfSeats, final int numberOfWheels) {
        serialNumber = UUID.randomUUID().toString();
        this.brand = brand;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }
}