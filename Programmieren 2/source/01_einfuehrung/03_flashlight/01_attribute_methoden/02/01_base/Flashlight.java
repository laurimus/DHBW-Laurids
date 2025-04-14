import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public char getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(char sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public byte getBatteryCount() {
        return batteryCount;
    }

    public void setBatteryCount(byte batteryCount) {
        if (batteryCount > 3) {
            throw new IllegalArgumentException("Battery count cannot exceed 3.");
        }
        this.batteryCount = batteryCount;
    }

    public short getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(short weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public int getLumenOutput() {
        return lumenOutput;
    }

    public void setLumenOutput(int lumenOutput) {
        this.lumenOutput = lumenOutput;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDateTime getLastMaintenanceDateTime() {
        return lastMaintenanceDateTime;
    }

    public void setLastMaintenanceDateTime(LocalDateTime lastMaintenanceDateTime) {
        this.lastMaintenanceDateTime = lastMaintenanceDateTime;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean waterproof) {
        isWaterproof = waterproof;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getBatteryLifeInHours() {
        return batteryLifeInHours;
    }

    public void setBatteryLifeInHours(float batteryLifeInHours) {
        if (batteryLifeInHours < 0) {
            throw new IllegalArgumentException("Battery life cannot be negative.");
        }

        float maxBatteryLife = 1000.0f;
        this.batteryLifeInHours = Math.min(batteryLifeInHours, maxBatteryLife);
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
        System.out.println("Flashlight is turned on to LOW mode.");
    }

    public void turnOn(Mode mode) {
        this.mode = mode;
        System.out.println("Flashlight is turned on to " + mode + " mode.");
    }

    public void turnOff() {
        this.mode = Mode.OFF;
        System.out.println("Flashlight is turned off.");
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
        System.out.println("Flashlight Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Mode: " + mode);
        System.out.println("Lumen Output: " + lumenOutput);
        System.out.println("Battery Life: " + batteryLifeInHours + " hours");
    }

    public void displayDetails(boolean includeMaintenanceInfo) {
        displayDetails();
        if (includeMaintenanceInfo) {
            System.out.println("Last Maintenance Date: " + lastMaintenanceDateTime);
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashlight that = (Flashlight) o;
        return serialNumber == that.serialNumber;
    }

    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    public String toString() {
        return "Flashlight{" + "sizeCategory=" + sizeCategory + ", brand='" + brand + '\'' + ", batteryCount=" + batteryCount + ", weightInGrams=" + weightInGrams + ", lumenOutput=" + lumenOutput + ", serialNumber=" + serialNumber + ", manufactureDate=" + manufactureDate + ", lastMaintenanceDateTime=" + lastMaintenanceDateTime + ", mode=" + mode + ", isWaterproof=" + isWaterproof + ", price=" + price + ", batteryLifeInHours=" + batteryLifeInHours + '}';
    }
}