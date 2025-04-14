import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Gate gateA1 = new Gate("A1", "Terminal 1");
        Flight flight101 = new Flight("FL101", "AirlineX", gateA1);
        log.info(String.valueOf(flight101));
        log.info("flight {} is assigned to Gate {}", flight101.getFlightNumber(), flight101.getGate().getGateNumber());
    }
}