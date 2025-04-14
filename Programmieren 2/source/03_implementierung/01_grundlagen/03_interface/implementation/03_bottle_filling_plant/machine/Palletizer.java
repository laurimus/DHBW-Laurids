package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Palletizer implements IMachine {
    public void process(List<Bottle> bottles) {
        long packedCount = bottles.stream().filter(Bottle::isPacked).count();
        log.info("{} bottles palletized and ready for shipping.", packedCount);
    }
}