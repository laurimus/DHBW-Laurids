import lombok.ToString;

@ToString(callSuper = true)
public class Truck extends Vehicle {
    private final boolean isPickup;

    public Truck(boolean isPickup) {
        super("truck", 2, 2, 4);
        this.isPickup = isPickup;
    }
}