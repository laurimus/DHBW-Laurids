import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Flight {
    private String flightNumber;
    private String airline;
    private Gate gate;     // 1:1 unidirectional association
}