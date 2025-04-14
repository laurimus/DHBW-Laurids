import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "serialNumber")
@ToString
@Slf4j
public class Flashlight {
    private char sizeCategory;
    private String brand;
    private byte batteryCount;
    private short weightInGrams;
    private int lumenOutput;
    private long serialNumber;
    private LocalDate manufactureDate;
    private LocalDateTime lastMaintenanceDateTime;
    private Mode mode;
    private boolean isWaterproof;
    private double price;
    private float batteryLifeInHours;

    public Flashlight(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBatteryCount(byte batteryCount) {
        if (batteryCount > 3) {
            throw new IllegalArgumentException("Battery count cannot exceed 3.");
        }
        this.batteryCount = batteryCount;
    }

    public void setBatteryLifeInHours(float batteryLifeInHours) {
        if (batteryLifeInHours < 0) {
            throw new IllegalArgumentException("Battery life cannot be negative.");
        }
        this.batteryLifeInHours = Math.min(batteryLifeInHours, 1000.0f);
        this.batteryLifeInHours = calculateAdjustedBatteryLife(this.batteryLifeInHours);
    }

    private float calculateAdjustedBatteryLife(float batteryLifeInHours) {
        float modeAdjustment = switch (this.mode) {
            case LOW -> 1.2f;
            case MEDIUM -> 1.0f;
            case HIGH -> 0.8f;
            case OFF -> 0.0f;
        };

        float batteryCountAdjustment = 1.0f + (this.batteryCount - 1) * 0.1f;
        float environmentalAdjustment = this.isWaterproof ? 0.9f : 1.0f;
        return Math.max(0, batteryLifeInHours * modeAdjustment * batteryCountAdjustment * environmentalAdjustment);
    }

    public void turnOn() {
        this.mode = Mode.LOW;
        log.info("Flashlight is turned on to LOW mode.");
    }

    public void turnOn(Mode mode) {
        this.mode = mode;
        log.info("Flashlight is turned on to {} mode.", mode);
    }

    public void turnOff() {
        this.mode = Mode.OFF;
        log.info("Flashlight is turned off.");
    }

    public double calculateTotalBatteryLife() {
        return batteryCount * batteryLifeInHours;
    }

    public double calculateTotalBatteryLife(float efficiencyFactor) {
        return batteryCount * batteryLifeInHours * efficiencyFactor;
    }
}