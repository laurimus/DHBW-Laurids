import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private String id;
    private String brand;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            log.warn("comparison failed: object is either null or not of type car.");
            return false;
        }

        Car car = (Car) object;
        boolean isEqual = id.equals(car.getId());

        log.debug("comparing car objects: {} and {}. result: {}", this, car, isEqual);

        return isEqual;
    }
}