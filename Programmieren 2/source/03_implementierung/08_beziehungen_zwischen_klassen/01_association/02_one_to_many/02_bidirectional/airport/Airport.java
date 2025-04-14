import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Airport {
    private final String airportCode;
    private final String airportName;
    private final String location;
    private final List<Flight> flights;

    public Airport(String airportCode, String airportName, String location) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.location = location;
        flights = new ArrayList<>();
    }

    public void addFlight(Flight... newFlights) {
        for (Flight flight : newFlights) {
            if (flight != null && !flights.contains(flight)) {
                flights.add(flight);
                flight.setAirport(this);
                log.info("flight {} added to airport {}.", flight.getFlightNumber(), airportName);
            } else {
                assert flight != null;
                log.warn("flight {} is already assigned or invalid.", flight.getFlightNumber());
            }
        }
    }

    public void removeFlight(Flight flight) {
        if (flights.remove(flight)) {
            flight.setAirport(null);
            log.info("flight {} removed from airport {}.", flight.getFlightNumber(), airportName);
        } else {
            log.warn("flight {} not found at airport {}.", flight.getFlightNumber(), airportName);
        }
    }

    public void displayAllFlights() {
        if (flights.isEmpty()) {
            log.info("no flights available at airport {}.", airportName);
        } else {
            log.info("flights available at airport {}: ", airportName);
            flights.forEach(flight -> log.info("flight {}: {} to {}", flight.getFlightNumber(), flight.getDepartureTime(), flight.getDestinationAirport()));
        }
    }
}