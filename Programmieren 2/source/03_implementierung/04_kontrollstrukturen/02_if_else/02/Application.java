import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        int year = new Car(2022).getManufacturingDate();
        log.info(year <= 1980 ? "antique car"
                : year <= 1990 ? "classic car"
                : year <= 2015 ? "semi-modern car"
                : "modern car");
    }
}