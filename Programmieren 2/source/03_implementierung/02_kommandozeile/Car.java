import lombok.Data;

@Data
public class Car {
    private final int id;
    private final String brand;
    private boolean allowedAtNight = false;
    private Usage usage;
}