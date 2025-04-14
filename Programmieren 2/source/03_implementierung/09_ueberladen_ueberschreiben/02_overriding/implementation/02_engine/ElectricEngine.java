import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
public class ElectricEngine extends Engine implements IEnergySource {
    private final double batteryCapacity;
    private double currentBatteryLevel;
    private boolean isCharging;

    public void start() {
        if (isEnergyAvailable()) {
            isRunning = true;
            log.info("{} (electric engine) started. battery level: {} kWh.", getModel(), currentBatteryLevel);
        } else log.warn("battery empty. cannot start engine.");
    }

    public void stop() {
        isRunning = false;
        log.info("{} (electric engine) stopped.", getModel());
    }

    public boolean isEnergyAvailable() {
        return currentBatteryLevel > 0;
    }

    public void displayStatus() {
        displayInfo();
        log.info("battery: {}/{} kWh, charging: {}", currentBatteryLevel, batteryCapacity, isCharging ? "yes" : "no");
    }

    public void consumeBattery(double amount) {
        if (currentBatteryLevel >= amount) {
            currentBatteryLevel -= amount;
            log.info("{} kWh consumed.", amount);
        } else log.warn("not enough battery. current: {} kWh.", currentBatteryLevel);
    }

    public void chargeBattery(double amount) {
        if ((currentBatteryLevel += amount) > batteryCapacity) {
            currentBatteryLevel = batteryCapacity;
            log.warn("battery full. excess ignored.");
        } else isCharging = true;
        log.info("{} kWh added.", amount);
    }
}