import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode(of = "serialNumber")
@ToString
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

    public Flashlight(char sizeCategory, String brand, byte batteryCount, short weightInGrams, int lumenOutput, long serialNumber, LocalDate manufactureDate, LocalDateTime lastMaintenanceDateTime, Mode mode, boolean isWaterproof, double price, float batteryLifeInHours) {
        this.sizeCategory = sizeCategory;
        this.brand = brand;
        setBatteryCount(batteryCount);
        this.weightInGrams = weightInGrams;
        this.lumenOutput = lumenOutput;
        this.serialNumber = serialNumber;
        this.manufactureDate = manufactureDate;
        this.lastMaintenanceDateTime = lastMaintenanceDateTime;
        this.mode = mode;
        this.isWaterproof = isWaterproof;
        this.price = price;
        setBatteryLifeInHours(batteryLifeInHours);
    }

    public Flashlight(long serialNumber) {
        this.serialNumber = serialNumber;
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

    public boolean isBrightEnough(int requiredLumens) {
        return this.lumenOutput >= requiredLumens;
    }

    public boolean isBrightEnough(int requiredLumens, int safetyMargin) {
        return this.lumenOutput >= (requiredLumens + safetyMargin);
    }

    public short calculateTotalWeight(short batteryWeightInGrams) {
        return (short) (this.weightInGrams + (batteryCount * batteryWeightInGrams));
    }

    public short calculateTotalWeight(short batteryWeightInGrams, short accessoryWeightInGrams) {
        return (short) (this.weightInGrams + (batteryCount * batteryWeightInGrams) + accessoryWeightInGrams);
    }

    public boolean isUnderWarranty(LocalDate currentDate, int warrantyYears) {
        return currentDate.isBefore(this.manufactureDate.plusYears(warrantyYears));
    }

    public boolean isUnderWarranty(LocalDate currentDate, int warrantyYears, int gracePeriodDays) {
        LocalDate warrantyEndDate = this.manufactureDate.plusYears(warrantyYears).plusDays(gracePeriodDays);
        return currentDate.isBefore(warrantyEndDate);
    }

    public void displayDetails() {
        log.info("Flashlight Details:");
        log.info("Brand: {}", brand);
        log.info("Serial Number: {}", serialNumber);
        log.info("Mode: {}", mode);
        log.info("Lumen Output: {}", lumenOutput);
        log.info("Battery Life: {} hours", batteryLifeInHours);
    }

    public void displayDetails(boolean includeMaintenanceInfo) {
        displayDetails();
        if (includeMaintenanceInfo) {
            log.info("Last Maintenance Date: {}", lastMaintenanceDateTime);
        }
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

    public void setBatteryLifeInHours(float batteryLifeInHours) {
        if (batteryLifeInHours < 0) {
            throw new IllegalArgumentException("Battery life cannot be negative.");
        }

        float maxBatteryLife = 1000.0f;
        this.batteryLifeInHours = Math.min(batteryLifeInHours, maxBatteryLife);
        this.batteryLifeInHours = calculateAdjustedBatteryLife(this.batteryLifeInHours);
    }
}