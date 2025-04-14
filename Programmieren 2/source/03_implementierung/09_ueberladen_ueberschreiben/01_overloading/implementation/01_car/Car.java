import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Builder
public class Car {
    private final String brand;
    private final String model;
    private final int horsepower;
    private final FuelType fuelType;
    private final double fuelConsumption;
    private final double tankCapacity;

    public double calculateRange() {
        return (tankCapacity / fuelConsumption) * 100;
    }

    public double calculateRange(double additionalFuel) {
        return ((tankCapacity + additionalFuel) / fuelConsumption) * 100;
    }

    public double calculateRange(List<Double> fuelStations) {
        double totalFuel = tankCapacity + fuelStations.stream().mapToDouble(Double::doubleValue).sum();
        return (totalFuel / fuelConsumption) * 100;
    }

    public double calculateRange(double additionalFuel, boolean ecoMode) {
        double consumptionFactor = ecoMode ? 0.9 : 1.0;
        return ((tankCapacity + additionalFuel) / (fuelConsumption * consumptionFactor)) * 100;
    }
}