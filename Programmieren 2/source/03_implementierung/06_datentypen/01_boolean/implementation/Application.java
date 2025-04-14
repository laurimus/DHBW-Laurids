import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car(true);
        log.info(String.valueOf(car));
    }
}