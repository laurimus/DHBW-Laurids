import lombok.Data;

@Data
public class TrafficLight {
    private Signal color = Signal.RED;

    public void change() {
        color = (color == Signal.RED) ? Signal.GREEN : Signal.RED;
    }
}