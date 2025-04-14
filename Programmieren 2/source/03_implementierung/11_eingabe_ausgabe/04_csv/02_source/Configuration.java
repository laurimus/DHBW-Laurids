import java.nio.file.FileSystems;

public enum Configuration {
    INSTANCE;

    private static final String SEP = FileSystems.getDefault().getSeparator();
    public final String userDirectory = System.getProperty("user.dir");
    public final String dataFile = userDirectory + SEP + "data" + SEP + "data.csv";
    public final String csvDelimiter = ",";
}