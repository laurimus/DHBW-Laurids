import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class Utility {
    private static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 8;
    private static final Random RANDOM = new Random();

    public String generateCarId() {
        return RANDOM.ints(LENGTH, 0, CHAR_POOL.length())
                .mapToObj(i -> String.valueOf(CHAR_POOL.charAt(i)))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}