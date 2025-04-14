public class Application {
    public static void main(String... args) {
        FuelEngine fuelEngine = FuelEngine.builder()
                .model("V8 Turbo")
                .powerOutput(450)
                .weight(250)
                .fuelType("Gasoline")
                .fuelCapacity(70)
                .currentFuelLevel(50)
                .build();

        ElectricEngine electricEngine = ElectricEngine.builder()
                .model("Tesla Powertrain")
                .powerOutput(350)
                .weight(200)
                .batteryCapacity(100)
                .currentBatteryLevel(80)
                .build();

        fuelEngine.displayStatus();
        electricEngine.displayStatus();

        fuelEngine.start();
        electricEngine.start();
        fuelEngine.consumeFuel(10);
        electricEngine.consumeBattery(20);

        fuelEngine.stop();
        electricEngine.stop();

        fuelEngine.displayStatus();
        electricEngine.displayStatus();
    }
}