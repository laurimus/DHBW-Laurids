public class Application {
    public static void main(String... args) {
        Airport airport = new Airport("LHR", "London Heathrow", "London");

        Flight flight01 = new Flight("BA123", "JFK", "10:00 AM"),
                flight02 = new Flight("UA456", "ORD", "12:30 PM"),
                flight03 = new Flight("AF789", "CDG", "3:00 PM");

        airport.addFlight(flight01, flight02, flight03);
        airport.displayAllFlights();

        flight01.displayFlightDetails();
        flight02.displayFlightDetails();

        airport.removeFlight(flight02);
        airport.displayAllFlights();
    }
}