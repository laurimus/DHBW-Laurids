import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class FuelInjector {
    private final String fuelType;
    private double fuelLevel = 100.0;

    public boolean injectFuel(double amount) {
        if (fuelLevel >= amount) {
            fuelLevel -= amount;
            log.info("injecting {} ml of {} fuel", amount, fuelType);
            return true;
        } else {
            log.warn("fuel tank empty. engine stops.");
            return false;
        }
    }
}