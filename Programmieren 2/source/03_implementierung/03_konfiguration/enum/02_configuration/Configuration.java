import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Locale;

public enum Configuration {
    INSTANCE;

    public final String localDateTimeZone = "Europe/Berlin";
    public final String localDateTimeFormat = "dd.MM.yyyy HH:mm:ss";
    public final ZoneOffset unixTimeZoneOffSet = ZoneOffset.UTC;
    public final TextStyle localDateTimeFormatTextStyle = TextStyle.SHORT;
    public final Locale localDateTimeLocale = Locale.GERMAN;

    public String toString() {
        return """
            +--- Configuration ------------------------------+
            localDateTimeZone            : %s
            localDateTimeFormat          : %s
            unixTimeZoneOffSet           : %s
            localDateTimeFormatTextStyle : %s
            localDateTimeLocale          : %s
            +""".formatted(localDateTimeZone, localDateTimeFormat, unixTimeZoneOffSet, localDateTimeFormatTextStyle, localDateTimeLocale);
    }
}