import lombok.ToString;

@ToString(callSuper = true)
public class Car extends Vehicle {
    public Car() {
        super("car", 4, 4, 4);
    }
}