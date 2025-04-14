package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Unscrambler implements IMachine {
    public void process(List<Bottle> bottles) {
        log.info("aligning bottles.");
    }
}