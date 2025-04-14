package shared;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Aircraft {
    private final String id;
    private double altitude;
    private double latitude;
    private double longitude;
    private double verticalSpeed;
}