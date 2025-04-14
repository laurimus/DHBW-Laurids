package machine;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RequiredArgsConstructor
public class ProductionLine {
    private final List<IMachine> machines;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    @SneakyThrows
    public void run(List<Bottle> bottles) {
        log.info("--- starting production line ---");

        for (IMachine machine : machines) {
            executor.submit(() -> machine.process(bottles)).get();
        }

        executor.shutdown();
        log.info("production line completed.");
    }
}