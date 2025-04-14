import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        FlightComputer flightComputer = new FlightComputer();

        flightComputer.getRoute();
        log.info("---");

        flightComputer.getRoute(true);
        log.info("---");

        flightComputer.getRoute("city");
        flightComputer.getRoute("airport");
        flightComputer.getRoute("both");
    }
}