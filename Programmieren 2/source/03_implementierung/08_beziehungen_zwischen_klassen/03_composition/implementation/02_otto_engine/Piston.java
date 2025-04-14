import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class Piston {
    private final int pistonNumber;
    private boolean isUp = false;

    public void move(String phase) {
        isUp = !isUp;
        log.info("piston {} ({} position) → {} phase", pistonNumber, isUp ? "up" : "down", phase);
    }
}