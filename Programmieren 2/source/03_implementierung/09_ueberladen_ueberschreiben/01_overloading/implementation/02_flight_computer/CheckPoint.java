import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Getter
@ToString
@RequiredArgsConstructor
public class CheckPoint {
    private final String shortName;
    private final String longName;
    private final double longitudeOfCity;
    private final double latitudeOfCity;
    private final double longitudeOfAirport;
    private final double latitudeOfAirport;
}