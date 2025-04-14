import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        int i = 0;

        while (i < 5) {
            log.info(String.valueOf(i));
            i++;
        }
    }
}