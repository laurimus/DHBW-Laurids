import lombok.SneakyThrows;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomFileWriter {
    private static final int ROWS = 1000;
    private static final int COLUMNS = 1000;
    private static final String FILE_PATH = "random_chars.txt";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CHARACTERS = "dhbwmos";
    private static final Random RANDOM_GENERATOR = new Random();

    @SneakyThrows
    public static void main(String... args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(FILE_PATH).toFile()))) {
            IntStream.range(0, ROWS).forEach(i -> writeLine(writer));
        }
    }

    @SneakyThrows
    private static void writeLine(BufferedWriter writer) {
        String line = RANDOM_GENERATOR.ints(COLUMNS, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .append(LINE_SEPARATOR)
                .toString();
        writer.write(line);
    }
}