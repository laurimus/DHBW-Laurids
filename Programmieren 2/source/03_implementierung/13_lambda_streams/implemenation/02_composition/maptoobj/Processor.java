import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@ToString
public class Processor {
    private final String name;
    private final List<Core> cores;

    public Processor(String name, int coreCount) {
        this.name = name;
        cores = IntStream.range(0, coreCount).mapToObj(i -> new Core("Core-" + (i + 1))).collect(Collectors.toList());
    }
}