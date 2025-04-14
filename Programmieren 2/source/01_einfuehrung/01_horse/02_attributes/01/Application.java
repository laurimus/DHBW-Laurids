import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        DressageHorse totilas = new DressageHorse("X");
        totilas.setName("Totilas");
        log.info(String.valueOf(totilas));
    }
}