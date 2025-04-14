import lombok.extern.slf4j.Slf4j;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ToString
public class VehicleRegistrationAuthority {
    private final String location;
    private final Map<String, Car> registeredCarMap;

    public VehicleRegistrationAuthority(String location) {
        this.location = location;
        registeredCarMap = new HashMap<>();
    }

    public void register(Car car) {
        registeredCarMap.put(car.getId(), car);
        log.info("registered car: {}", car.getId());
    }

    public boolean isCarRegistered(String id) {
        return registeredCarMap.containsKey(id);
    }

    public int getNumberOfRegisteredCars() {
        return registeredCarMap.size();
    }

    public void unregisterCar(Car car) {
        if (isCarRegistered(car.getId())) {
            registeredCarMap.remove(car.getId());
            log.info("car {} found and unregistered.", car.getId());
        } else {
            log.info("car {} not found.", car.getId());
        }
    }

    public void report() {
        log.info("--- report ---");
        registeredCarMap.forEach((id, car) -> log.info("Car: {}", car));
        log.info("total cars registered: {}", registeredCarMap.size());
    }
}