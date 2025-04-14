package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Labeler implements IMachine {
    public void process(List<Bottle> bottles) {
        bottles.stream().filter(Bottle::isCapped).forEach(b -> b.setLabeled(true));
        log.info("bottles labeled.");
    }
}