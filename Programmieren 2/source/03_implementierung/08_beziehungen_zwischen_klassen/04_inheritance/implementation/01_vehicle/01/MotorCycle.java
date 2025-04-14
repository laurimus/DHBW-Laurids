import lombok.ToString;

@ToString(callSuper = true)
public class MotorCycle extends Vehicle {
    public MotorCycle(int numberOfSeats) {
        super("motor cycle", 0, numberOfSeats, 2);
    }
}