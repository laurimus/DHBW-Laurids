import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car01 = new Car("U7JNH5HBZ", "ABC");
        Car car02 = new Car("KI8IOPNHG", "XYZ");
        Car car03 = new Car("U7JNH5HBZ", "ABC");
        Car car04 = car03;

        log.info("car01: {}", car01);
        log.info("car02: {}", car02);
        log.info("car03: {}", car03);
        log.info("car04: {}", car04);

        log.info("--- comparison results ---");

        log.info("car01 == car02      : {}", car01 == car02);
        log.info("car01.equals(car02) : {}", car01.equals(car02));
        log.info("car01.equals(car03) : {}", car01.equals(car03));
        log.info("car03 == car04      : {}", car03 == car04);
    }
}