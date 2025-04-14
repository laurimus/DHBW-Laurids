import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void entryEnvironmentalZone(Car car) {
        switch (car.getEnvironmentalSticker()) {
            case 'A', 'B', 'C' ->
                    log.info("car with sticker {} is allowed to enter the environmental zone", car.getEnvironmentalSticker());
            default ->
                    log.info("car with sticker {} is not allowed to enter the environmental zone", car.getEnvironmentalSticker());
        }
    }

    public static void main(String... args) {
        Car car01 = new Car();
        car01.setEnvironmentalSticker((char) 65);
        entryEnvironmentalZone(car01);

        Car car02 = new Car();
        car02.setEnvironmentalSticker((char) 69);
        entryEnvironmentalZone(car02);
    }
}