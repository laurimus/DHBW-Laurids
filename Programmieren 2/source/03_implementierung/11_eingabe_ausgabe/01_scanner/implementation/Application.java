import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car(887250, "eCar");

        String insurance = InputUtils.readString("[insurance]: ");
        car.setInsurance(insurance);

        double tax = InputUtils.readDouble("[tax]: ");
        car.setTax(tax);

        int defaultParkingSpaceID = InputUtils.readInt("[defaultParkingSpaceID]: ");
        car.setDefaultParkingSpaceID(defaultParkingSpaceID);

        Usage usage = InputUtils.readEnum(Usage.class, "[usage (Private | Business)]: ");
        car.setUsage(usage);

        log.info(String.valueOf(car));
    }
}