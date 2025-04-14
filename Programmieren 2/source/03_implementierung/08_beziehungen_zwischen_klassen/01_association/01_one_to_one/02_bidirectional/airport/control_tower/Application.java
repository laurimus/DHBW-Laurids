public class Application {
    public static void main(String... args) {
        String[] commChannels = {"VHF 118.00 MHz", "VHF 119.50 MHz"};
        ControlTower controlTower = new ControlTower("LHR Tower", "LHR001", commChannels, true);
        Airport airport = new Airport("LHR", "London Heathrow", "London, UK");

        airport.assignControlTower(controlTower);

        controlTower.performRadarCheck();
        controlTower.communicateWithAircraft("cleared for takeoff.");
    }
}