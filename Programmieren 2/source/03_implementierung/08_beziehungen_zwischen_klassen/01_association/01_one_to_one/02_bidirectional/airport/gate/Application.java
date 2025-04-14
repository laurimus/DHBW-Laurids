import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Gate gateA1 = new Gate("A1", "Terminal 1");
        Flight flight101 = new Flight("FL101", "AirlineX");

        flight101.assignToGate(gateA1);

        log.info("flight : {}", flight101);
        log.info("gate   : {}", gateA1);

        gateA1.removeFlight();

        log.info("--- after removal ---");
        log.info("flight : {}", flight101);
        log.info("gate   : {}", gateA1);
    }
}