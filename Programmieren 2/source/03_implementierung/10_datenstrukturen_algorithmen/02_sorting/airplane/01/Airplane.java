import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Airplane {
    private long serialNumber;
    private String registrationID;
    private LocalDate manufacturingDate;
    private Carrier carrier;
}