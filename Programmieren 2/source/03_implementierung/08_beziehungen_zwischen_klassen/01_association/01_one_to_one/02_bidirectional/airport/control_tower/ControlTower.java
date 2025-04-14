import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ControlTower {
    private final String towerName;
    private final String towerCode;
    private final String[] communicationChannels;
    private final boolean radarSystemOperational;
    private Airport airport;

    public void linkToAirport(Airport airport) {
        if (this.airport == null) {
            this.airport = airport;
            log.info("control tower {} now linked to airport {}.", towerName, airport.getAirportName());
        }
    }

    public void performRadarCheck() {
        String status = radarSystemOperational ? "operational" : "down";
        log.info("radar system at {} is {}.", towerName, status);
    }

    public void communicateWithAircraft(String message) {
        if (communicationChannels.length > 0) {
            log.info("communication on {}: {}", communicationChannels[0], message);
        } else {
            log.warn("no communication channels available at {}.", towerName);
        }
    }
}