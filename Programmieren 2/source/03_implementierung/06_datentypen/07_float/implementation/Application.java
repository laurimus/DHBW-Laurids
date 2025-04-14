import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        // float | IEEE 754 floating point
        //         default : 0.0
        //         size    : 32 bits
        //         range   : upto 7 decimal digits

        float value = (float) (1.42222 * 234.56433);
        log.info(String.valueOf(value));
    }
}