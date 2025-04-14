import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        log.info(prompt);
        return scanner.nextLine();
    }

    public static double readDouble(String prompt) {
        log.info(prompt);
        return scanner.nextDouble();
    }

    public static int readInt(String prompt) {
        log.info(prompt);
        return scanner.nextInt();
    }

    public static <T extends Enum<T>> T readEnum(Class<T> enumClass, String prompt) {
        log.info(prompt);
        String input = scanner.next().toUpperCase();
        return Enum.valueOf(enumClass, input);
    }
}