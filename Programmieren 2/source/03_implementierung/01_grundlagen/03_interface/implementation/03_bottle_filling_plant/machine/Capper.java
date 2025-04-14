package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Capper implements IMachine {
    public void process(List<Bottle> bottles) {
        bottles.stream().filter(Bottle::isFilled).forEach(b -> b.setCapped(true));
        log.info("bottles capped.");
    }
}