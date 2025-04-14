public class Application {
    public static void main(String... args) {
        AirportTerminal terminal = new AirportTerminal("Terminal A", "North Wing, JFK", 5000, true);
        Airline airline = new Airline("AA123", "American Airlines", "Dallas, TX");
        airline.assignAirportTerminal(terminal);
        airline.displayAirlineDetails();
        airline.handleCheckIn(200);
        airline.scheduleFlight("AA101", "2025-02-01 15:00");
    }
}