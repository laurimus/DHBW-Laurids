import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Flight {
    private final String flightNumber;
    private final String airline;
    private Gate gate;    // bidirectional association

    public Flight(String flightNumber, String airline) {
        this.flightNumber = flightNumber;
        this.airline = airline;
    }

    public void assignToGate(Gate gate) {
        this.gate = gate;
        if (gate.getFlight() != this) {
            gate.assignFlight(this); // ensure bidirectional consistency
        }
    }

    public void removeFromGate() {
        if (this.gate != null) {
            Gate currentGate = this.gate;
            this.gate = null;
            if (currentGate.getFlight() == this) {
                currentGate.removeFlight(); // ensure bidirectional consistency
            }
        }
    }
}