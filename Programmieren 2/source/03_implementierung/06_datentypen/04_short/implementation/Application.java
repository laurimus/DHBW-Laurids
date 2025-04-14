import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        short currentOdometerValue = 0;
        Car car = new Car();

        for (int i = 0; i < 263; i++) {
            currentOdometerValue += 125;
            car.setOdometerValue(currentOdometerValue);
            log.info(String.valueOf(car));
        }
    }
}