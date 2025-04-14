import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Car {
    private final String id;
    private final CarBrand brand;

    public Car(CarBrand brand) {
        id = Utility.generateCarId();
        this.brand = brand;
    }
}