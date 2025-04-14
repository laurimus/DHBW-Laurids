import lombok.Data;

@Data
// composition (physical inclusion)
public class Bulb {
    private final String type;
    private final int lifespanInHours;
}