import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class AirportTerminal {
    private final String terminalName, terminalLocation;
    private final int maximumCapacity;
    private boolean isOperational;

    public void processCheckIn(int numberOfPassengers) {
        if (!isOperational) {
            log.warn("terminal {} is not operational.", terminalName);
        } else if (numberOfPassengers > maximumCapacity) {
            log.warn("terminal {} cannot handle {} passengers. requested: {}.", terminalName, maximumCapacity, numberOfPassengers);
        } else {
            log.info("{} passengers checked in at terminal {}.", numberOfPassengers, terminalName);
        }
    }

    public void scheduleFlight(String flightCode, String departureTime) {
        if (!isOperational) {
            log.warn("terminal {} not operational. cannot schedule flight {}.", terminalName, flightCode);
        } else {
            log.info("flight {} scheduled at terminal {} for departure at {}.", flightCode, terminalName, departureTime);
        }
    }
}