import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Airport {
    private final String airportCode;
    private final String airportName;
    private final String location;
    private ControlTower controlTower;

    public void assignControlTower(ControlTower controlTower) {
        if (this.controlTower == null) {
            this.controlTower = controlTower;
            controlTower.linkToAirport(this);
            log.info("control tower {} assigned to {}.", controlTower.getTowerName(), airportName);
        }
    }
}