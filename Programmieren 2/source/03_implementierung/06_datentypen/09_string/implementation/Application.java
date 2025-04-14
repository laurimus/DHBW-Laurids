import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Application {
    public static void main(String... args) {
        String string = "Software Engineering";
        log.info("string      : {}", string);
        log.info("isEmpty     : {}", string.isEmpty());
        log.info("length      : {}", string.length());
        log.info("contains    : {}", string.contains("Engineering"));
        log.info("indexOf     : {}", string.indexOf("Engineering"));
        log.info("matches     : {}", string.matches(".*ware.*"));
        log.info("startsWith  : {}", string.startsWith("S"));
        log.info("endsWith    : {}", string.endsWith("S"));
        log.info("toLowerCase : {}", string.toLowerCase());
        log.info("toUpperCase : {}", string.toUpperCase());
        log.info("charArray   : {}", Arrays.toString(string.toCharArray()));
        log.info("subString   : {}", string.substring(0, 8));
        log.info("split       : {}", Arrays.toString(string.split(" ")));
        log.info("getBytes    : {}", Arrays.toString(string.getBytes()));
    }
}