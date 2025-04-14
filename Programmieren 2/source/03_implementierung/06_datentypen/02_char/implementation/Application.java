import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car();

        car.setEnvironmentalSticker((char) 65);
        log.info(String.valueOf(car));

        car.setEnvironmentalSticker('A');
        log.info(String.valueOf(car));
    }
}