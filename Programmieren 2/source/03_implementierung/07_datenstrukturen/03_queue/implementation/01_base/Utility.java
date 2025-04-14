import lombok.experimental.UtilityClass;
import java.util.Random;

@UtilityClass
public class Utility {
    private static final String PREFIX = "MGH";
    private static final Random RANDOM = new Random();

    public static String generateLicensePlate() {
        return "%s-%s-%03d".formatted(
                PREFIX,
                RANDOM.ints('A', 'Z' + 1)
                        .limit(RANDOM.nextInt(2) + 1)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append),
                RANDOM.nextInt(900) + 100
        );
    }
}