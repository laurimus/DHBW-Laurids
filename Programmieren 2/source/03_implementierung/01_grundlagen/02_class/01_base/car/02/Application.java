import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car();
        car.setSerialNumber(837371125);
        log.info(String.valueOf(car));

        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();
        log.info(String.valueOf(car));

        car.decreaseSpeed();
        log.info(String.valueOf(car));

        car.stop();
        log.info(String.valueOf(car));
    }
}