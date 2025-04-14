import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@ToString
public class FlightCrew {
    private final Captain captain;
    private final List<Pilot> pilots;
    private final FlightAttendant flightAttendant;
    private final Purser purser;
}