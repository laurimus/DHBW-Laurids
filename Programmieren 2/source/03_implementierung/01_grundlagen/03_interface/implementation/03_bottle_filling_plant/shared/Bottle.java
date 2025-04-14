package shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Bottle {
    private String id;
    private LiquidType liquidType;
    private boolean rinsed;
    private boolean filled;
    private boolean capped;
    private boolean labeled;
    private boolean packed;
}