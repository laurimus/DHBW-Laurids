import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
public class FlightComputer {
    private List<CheckPoint> checkPointList = List.of(
            new CheckPoint("BRU", "Brussels", 50.850346, 4.351721, 50.90082973, 4.483998064),
            new CheckPoint("AMS", "Amsterdam", 52.370216, 4.895168, 52.3076865, 4.767424099999971),
            new CheckPoint("LHR", "London", 51.507351, -0.127758, 51.470020, -0.454295),
            new CheckPoint("JFK", "New York", 40.712776, -74.005974, 40.6441666667, -73.7822222222)
    );

    public void getRoute() {
        log.info("--- check points ---");
        String route = String.join(" ", checkPointList.stream()
                .map(CheckPoint::getShortName)
                .toList());
        log.info(route);
    }

    public void getRoute(boolean areCitiesPrinted) {
        if (areCitiesPrinted) {
            log.info("--- check points (including cities) ---");
            checkPointList.forEach(cp -> log.info("{} {}", cp.getShortName(), cp.getLongName()));
        } else {
            getRoute();
        }
    }

    public void getRoute(String coordinatesType) {
        log.info("--- check points ({}) ---", coordinatesType);

        checkPointList.forEach(cp -> {
            switch (coordinatesType) {
                case "city" -> log.info("{}\t({},{})",
                        cp.getLongName(), formatCoordinate(cp.getLongitudeOfCity()), formatCoordinate(cp.getLatitudeOfCity()));
                case "airport" -> log.info("{}\t({},{})",
                        cp.getShortName(), formatCoordinate(cp.getLongitudeOfAirport()), formatCoordinate(cp.getLatitudeOfAirport()));
                case "both" -> log.info("{} / {}\t({},{})\t({},{})",
                        cp.getLongName(), cp.getShortName(),
                        formatCoordinate(cp.getLongitudeOfCity()), formatCoordinate(cp.getLatitudeOfCity()),
                        formatCoordinate(cp.getLongitudeOfAirport()), formatCoordinate(cp.getLatitudeOfAirport()));
            }
        });
    }

    private String formatCoordinate(double coordinate) {
        return String.format("%.6f", coordinate);
    }
}