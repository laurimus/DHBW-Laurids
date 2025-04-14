import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Car {
    private final int id;
    private final int length;
    private final int width;
    private final int height;
    private final CarModel model;
    private final int numberOfDoors;
    private final int numberOfSeats;
    private boolean available;
}