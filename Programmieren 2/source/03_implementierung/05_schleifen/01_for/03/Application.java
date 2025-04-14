import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        for (int i = 5; i >= 0; i--) {
            log.info(String.valueOf(i));
        }
    }
}