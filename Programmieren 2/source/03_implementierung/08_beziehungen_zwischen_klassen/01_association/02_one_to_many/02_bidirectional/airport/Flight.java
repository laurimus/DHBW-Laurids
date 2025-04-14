import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Flight {
    private final String flightNumber;
    private final String destinationAirport;
    private final String departureTime;
    @Setter
    private Airport airport;

    public void displayFlightDetails() {
        log.info("flight {}: departing from {} to {} at {}", flightNumber, airport.getAirportName(), destinationAirport, departureTime);
    }
}