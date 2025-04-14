import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Processor processor = new Processor("Intel i7", 4);
        log.info(String.valueOf(processor));
    }
}