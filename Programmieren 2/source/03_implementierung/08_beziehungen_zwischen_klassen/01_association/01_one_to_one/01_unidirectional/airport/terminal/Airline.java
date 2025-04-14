import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Airline {
    private final String airlineCode, airlineName, headquarters;
    private AirportTerminal airportTerminal;

    public void assignAirportTerminal(AirportTerminal terminal) {
        if (airportTerminal == null) {
            airportTerminal = terminal;
            log.info("airline {} assigned to terminal {}.", airlineCode, terminal.getTerminalName());
        } else {
            log.warn("airline {} already assigned to terminal {}.", airlineCode, airportTerminal.getTerminalName());
        }
    }

    public void displayAirlineDetails() {
        log.info("airline: {} (code: {}). HQ: {}. terminal: {}.", airlineName, airlineCode, headquarters,
                airportTerminal != null ? airportTerminal.getTerminalName() : "no terminal assigned");
    }

    public void handleCheckIn(int numberOfPassengers) {
        if (airportTerminal != null) {
            airportTerminal.processCheckIn(numberOfPassengers);
            log.info("{} passengers checked in at terminal {}.", numberOfPassengers, airportTerminal.getTerminalName());
        } else {
            log.warn("no terminal assigned to airline {} for check-in.", airlineCode);
        }
    }

    public void scheduleFlight(String flightCode, String departureTime) {
        if (airportTerminal != null) {
            airportTerminal.scheduleFlight(flightCode, departureTime);
            log.info("flight {} scheduled from terminal {} at {}.", flightCode, airportTerminal.getTerminalName(), departureTime);
        } else {
            log.warn("no terminal assigned to airline {} for flight scheduling.", airlineCode);
        }
    }
}