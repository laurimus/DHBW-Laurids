package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Packager implements IMachine {
    public void process(List<Bottle> bottles) {
        bottles.stream().filter(Bottle::isLabeled).forEach(b -> b.setPacked(true));
        log.info("bottles packed.");
    }
}