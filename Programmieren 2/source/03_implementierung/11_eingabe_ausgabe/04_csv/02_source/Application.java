import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

@Slf4j
public class Application {
    @SneakyThrows
    public static void main(String... args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Configuration.INSTANCE.dataFile))) {
            bufferedReader.lines()
                    .map(line -> line.split(Configuration.INSTANCE.csvDelimiter))
                    .map(Arrays::toString)
                    .forEach(log::info);
        }
    }
}