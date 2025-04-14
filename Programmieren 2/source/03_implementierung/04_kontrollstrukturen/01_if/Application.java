import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        if (new Car(1972).getManufacturingDate() <= 1980) log.info("classic car");
    }
}