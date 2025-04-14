import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        int i = 0;

        do {
            log.info(String.valueOf(i));
            i++;
        } while (i < 5);
    }
}