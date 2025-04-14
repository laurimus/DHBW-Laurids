import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        VehicleRegistrationAuthority vehicleRegistrationAuthority = new VehicleRegistrationAuthority("Bad Mergentheim");

        Car car01 = new Car(CarBrand.MAZDA);
        Car car02 = new Car(CarBrand.TOYOTA);
        Car car03 = new Car(CarBrand.TOYOTA);
        Car car04 = new Car(CarBrand.MAZDA);
        Car car05 = new Car(CarBrand.MAZDA);

        vehicleRegistrationAuthority.register(car01);
        vehicleRegistrationAuthority.register(car02);
        vehicleRegistrationAuthority.register(car03);
        vehicleRegistrationAuthority.register(car04);
        vehicleRegistrationAuthority.register(car05);

        vehicleRegistrationAuthority.report();

        log.info("numberOfRegisteredCars              : {}", vehicleRegistrationAuthority.getNumberOfRegisteredCars());
        log.info("isCarRegistered (id = u7jn6gtb6zop) : {}", vehicleRegistrationAuthority.isCarRegistered("u7jn6gtb6zop"));
        log.info("isCarRegistered (id = u7jn7gtb6zop) : {}", vehicleRegistrationAuthority.isCarRegistered("u7jn7gtb6zop"));

        vehicleRegistrationAuthority.unregisterCar(car04);
        log.info("-");
        vehicleRegistrationAuthority.report();
    }
}