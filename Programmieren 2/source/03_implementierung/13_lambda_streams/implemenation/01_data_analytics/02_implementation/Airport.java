import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Airport {
    private String airportCode;
    private String airportName;
    private List<Flight> flights;
}