import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@SuperBuilder
public abstract class Engine {
    private final String model;
    private final int powerOutput;
    private final double weight;
    protected boolean isRunning;

    public abstract void start();

    public abstract void stop();

    public void displayInfo() {
        log.info("engine model   : {}", model);
        log.info("power output   : {} HP", powerOutput);
        log.info("weight         : {} kg", weight);
        log.info("engine running : {}", isRunning);
    }
}