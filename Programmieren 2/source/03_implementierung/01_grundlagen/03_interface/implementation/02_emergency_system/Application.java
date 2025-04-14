import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
public class Application {
    public static void main(String... args) {
        List<CarEmergencySystem> cars = List.of(
                new CarEmergencySystem("Toyota Camry", "ABC123"),
                new CarEmergencySystem("Honda Civic", "XYZ456"),
                new CarEmergencySystem("BMW X5", "LMN789"));

        cars.stream().peek(car -> {
            EmergencyType emergency = EmergencyType.values()[new Random().nextInt(EmergencyType.values().length)];
            log.info("Simulating emergency for car: {} with license plate {}", car.getCarModel(), car.getLicensePlate());
            car.handleEmergency(emergency);
        }).toList();
    }
}