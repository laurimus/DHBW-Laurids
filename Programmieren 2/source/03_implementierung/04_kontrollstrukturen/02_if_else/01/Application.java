import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        log.info(new Car(2020).getManufacturingDate() <= 1980 ? "classic car" : "modern car");
    }
}