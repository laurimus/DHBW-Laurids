import lombok.Data;

@Data
public class Car {
    private final int id;
    private final String brand;
    private String insurance;
    private double tax;
    private int defaultParkingSpaceID;
    private Usage usage;
}