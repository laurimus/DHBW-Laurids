import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car {
    public Car() {
        log.info("car build");
    }

    public static class Engine {
        public Engine() {
            log.info("engine build");
        }
    }
}