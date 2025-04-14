import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        for (int i = 0; i < 5; i += 2) {
            log.info(String.valueOf(i));
        }
    }
}