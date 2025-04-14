import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Gate {
    private final String gateNumber;
    private final String terminal;
    @ToString.Exclude
    private Flight flight;    // bidirectional association

    public Gate(String gateNumber, String terminal) {
        this.gateNumber = gateNumber;
        this.terminal = terminal;
    }

    public void assignFlight(Flight flight) {
        this.flight = flight;
        if (flight.getGate() != this) {
            flight.assignToGate(this); // ensure bidirectional consistency
        }
    }

    public void removeFlight() {
        if (this.flight != null) {
            Flight currentFlight = this.flight;
            this.flight = null;
            if (currentFlight.getGate() == this) {
                currentFlight.removeFromGate(); // ensure bidirectional consistency
            }
        }
    }
}