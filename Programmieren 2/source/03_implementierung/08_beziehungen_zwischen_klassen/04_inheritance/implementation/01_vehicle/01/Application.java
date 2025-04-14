import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car();
        log.info(String.valueOf(car));
        log.info("---");

        MotorCycle motorCycle = new MotorCycle(2);
        log.info(String.valueOf(motorCycle));
        log.info("---");

        Truck truck = new Truck(true);
        log.info(String.valueOf(truck));
    }
}