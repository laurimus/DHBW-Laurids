import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ToString
public class Car implements ICar {
    private final String model;

    public void accelerate() {
        log.info("{} is accelerating.", model);
    }

    public void brake() {
        log.info("{} is braking.", model);
    }

    public void turn(Direction direction) {
        log.info("{} is {} turning.", model, direction);
    }
}