import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Slf4j
public class Application {
    public static String checkIfShopIsOpen(LocalDateTime localDateTime) {
        return switch (localDateTime.getDayOfWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, FRIDAY -> "welcome - shop is open";
            default -> "sorry - shop is closed";
        };
    }

    public static void main(String... args) {
        ZoneId zone = ZoneId.of("Europe/Berlin");
        LocalDateTime localDateTime = LocalDateTime.now(zone);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        log.info("localDateTime           : {}", localDateTime);
        log.info("formatted dateTime      : {}", dateTimeFormatter.format(localDateTime));
        log.info("unix time in seconds    : {}", localDateTime.toEpochSecond(ZoneOffset.UTC));
        log.info("converted localDateTime : {}", LocalDateTime.ofEpochSecond(localDateTime.toEpochSecond(ZoneOffset.UTC), 0, ZoneOffset.UTC));
        log.info("+5 days                 : {}", dateTimeFormatter.format(localDateTime.plusDays(5)));
        log.info("+1 year and 5 days      : {}", dateTimeFormatter.format(localDateTime.plusYears(1).plusDays(5)));

        for (int i = 0; i < 7; i++) {
            log.info("{}\t : {}", localDateTime.plusDays(i).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.GERMAN), checkIfShopIsOpen(localDateTime.plusDays(i)));
        }
    }
}