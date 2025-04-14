import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Application {
    public static String checkIfShopIsOpen(LocalDateTime dateTime) {
        return switch (dateTime.getDayOfWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, FRIDAY -> "Welcome - Shop is open";
            default -> "Sorry - Shop is closed";
        };
    }

    public static void main(String... args) {
        log.info("{}", Configuration.INSTANCE);

        ZoneId zone = ZoneId.of(Configuration.INSTANCE.localDateTimeZone);
        LocalDateTime dateTime = LocalDateTime.now(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Configuration.INSTANCE.localDateTimeFormat);

        log.info("localDateTime        : {}", dateTime);
        log.info("dateTimeFormatString : {}", formatter.format(dateTime));
        log.info("unixTimeInSeconds    : {}", dateTime.toEpochSecond(Configuration.INSTANCE.unixTimeZoneOffSet));

        dateTime = LocalDateTime.ofEpochSecond(dateTime.toEpochSecond(Configuration.INSTANCE.unixTimeZoneOffSet), 0, Configuration.INSTANCE.unixTimeZoneOffSet);
        log.info("localDateTime        : {}", dateTime);
        log.info("+5 days              : {}", formatter.format(dateTime.plusDays(5)));
        log.info("+1 year and 5 days   : {}", formatter.format(dateTime.plusYears(1).plusDays(5)));

        for (int i = 0; i < 7; i++)
            log.info("{}\t | {}", dateTime.plusDays(i).getDayOfWeek().getDisplayName(Configuration.INSTANCE.localDateTimeFormatTextStyle, Configuration.INSTANCE.localDateTimeLocale), checkIfShopIsOpen(dateTime.plusDays(i)));
    }
}