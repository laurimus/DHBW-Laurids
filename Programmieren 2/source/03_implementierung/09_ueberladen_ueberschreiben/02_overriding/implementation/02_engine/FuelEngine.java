import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
public class FuelEngine extends Engine implements IFuelSource {
    private final String fuelType;
    private final double fuelCapacity;
    private double currentFuelLevel;

    public void start() {
        if (isEnergyAvailable()) {
            isRunning = true;
            log.info("{} (fuel engine) started using {} fuel.", getModel(), fuelType);
        } else log.warn("fuel empty. cannot start engine.");
    }

    public void stop() {
        isRunning = false;
        log.info("{} (fuel engine) stopped.", getModel());
    }

    public boolean isEnergyAvailable() {
        return currentFuelLevel > 0;
    }

    public void displayStatus() {
        displayInfo();
        log.info("fuel: {}/{} L ({})", currentFuelLevel, fuelCapacity, fuelType);
    }

    public void consumeFuel(double amount) {
        if (currentFuelLevel >= amount) {
            currentFuelLevel -= amount;
            log.info("{} L consumed.", amount);
        } else log.warn("not enough fuel. current: {} L.", currentFuelLevel);
    }
}