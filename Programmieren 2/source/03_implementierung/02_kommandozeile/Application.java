import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = new Car(887250, "eCar");

        // iterate through command-line arguments
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i].toLowerCase()) {
                // if the argument is "-allowedatnight", parse the next value as a boolean and set it
                case "-allowedatnight" -> car.setAllowedAtNight(Boolean.parseBoolean(args[++i]));
                // if the argument is "-usage", parse the next value as an enum constant (case-insensitive)
                case "-usage" -> car.setUsage(Usage.valueOf(args[++i].toUpperCase()));
                // log a warning for any unknown arguments
                default -> log.warn("unknown argument: {}", args[i]);
            }
        }

        log.info("car details: {}", car);
    }
}