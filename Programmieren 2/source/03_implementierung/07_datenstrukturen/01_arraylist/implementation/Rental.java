import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Rental {
    private final ArrayList<Car> carList;

    public Rental() {
        carList = new ArrayList<>();
        initCarList();
    }

    private void initCarList() {
        carList.add(new Car(1, 2000, 1000, 1500, CarModel.V1, 4, 4, true));
        carList.add(new Car(2, 1750, 1750, 1250, CarModel.V2, 4, 5, true));
        carList.add(new Car(3, 1550, 1225, 1350, CarModel.VC, 2, 2, true));
        carList.add(new Car(4, 1250, 1050, 1700, CarModel.VC, 2, 2, true));
        carList.add(new Car(5, 1350, 1150, 1550, CarModel.V3, 4, 5, true));
    }

    public boolean isCarAvailable(int carId) {
        return carList.stream().filter(car -> car.getId() == carId).anyMatch(Car::isAvailable);
    }

    public void rentCar(int carId) {
        carList.stream().filter(car -> car.getId() == carId).findFirst().ifPresentOrElse(car -> {
            if (car.isAvailable()) {
                car.setAvailable(false);
                log.info("rent car with id {}: {}", carId, car);
            } else {
                log.info("car with id {} is not available for rent", carId);
            }
        }, () -> log.info("car with id {} not found", carId));
        log.info("---");
    }

    public void returnCar(int carId) {
        carList.stream().filter(car -> car.getId() == carId).findFirst().ifPresentOrElse(car -> {
            car.setAvailable(true);
            log.info("return car with id {}: {}", carId, car);
        }, () -> log.info("car with id {} not found", carId));
    }
}