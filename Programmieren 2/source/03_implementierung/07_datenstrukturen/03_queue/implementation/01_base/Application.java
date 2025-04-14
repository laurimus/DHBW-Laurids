import java.util.stream.Stream;

public class Application {
    public static void main(String... args) {
        CarWash carWash = new CarWash("Bad Mergentheim");

        Stream.of(CarBrand.MAZDA, CarBrand.TOYOTA, CarBrand.MAZDA)
                .map(brand -> new Car(Utility.generateLicensePlate(), brand))
                .forEach(carWash::registerCar);

        carWash.start();
        carWash.start();

        carWash.registerCar(new Car(Utility.generateLicensePlate(), CarBrand.MAZDA));

        carWash.start();
        carWash.start();
    }
}