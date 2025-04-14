import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class Cylinder {
    private final int cylinderNumber;
    private final Piston piston;

    public void performCycle() {
        for (String phase : new String[]{"Intake", "Compression", "Power", "Exhaust"}) piston.move(phase);
    }
}