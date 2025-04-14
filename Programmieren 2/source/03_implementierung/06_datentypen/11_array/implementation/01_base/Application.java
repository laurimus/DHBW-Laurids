import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        int[] data = new int[]{8, 4, 2, 5, 1, 3, 9, 6, 7};

        for (int value : data) {
            log.info(String.valueOf(value));
        }
    }
}