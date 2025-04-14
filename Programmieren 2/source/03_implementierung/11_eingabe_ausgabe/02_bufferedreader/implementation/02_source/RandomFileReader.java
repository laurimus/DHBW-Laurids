import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.stream.IntStream;

@Slf4j
public class RandomFileReader {
    private static final String FILE_PATH = "random_chars.txt";
    private static final String SEARCH_TERM = "dhbwmos";

    @SneakyThrows
    public static void main(String... args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(FILE_PATH).toFile()))) {
            long result = IntStream.iterate(1, i -> searchLine(reader, i), i -> i + 1).count();
            log.info(String.valueOf(result));
        }
    }

    @SneakyThrows
    private static boolean searchLine(BufferedReader reader, int lineNumber) {
        String line = reader.readLine();
        if (line == null) return false;

        int column = line.indexOf(SEARCH_TERM);
        if (column != -1) {
            log.info("found '{}' at line {}, column {}", SEARCH_TERM, lineNumber, column);
        }
        return true;
    }
}