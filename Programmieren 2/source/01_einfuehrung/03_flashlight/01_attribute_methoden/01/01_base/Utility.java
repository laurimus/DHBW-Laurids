import java.text.DecimalFormat;

public class Utility {
    public static String formatTwoDecimals(double value) {
        return new DecimalFormat("0.00").format(value);
    }
}