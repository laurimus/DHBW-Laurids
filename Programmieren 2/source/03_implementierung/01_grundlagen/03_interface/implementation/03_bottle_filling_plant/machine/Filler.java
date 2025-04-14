package machine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shared.Bottle;
import shared.LiquidType;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Filler implements IMachine {
    private final LiquidType liquidType;

    public void process(List<Bottle> bottles) {
        bottles.stream().filter(Bottle::isRinsed).forEach(b -> {
            b.setFilled(true);
            b.setLiquidType(liquidType);
        });
        log.info("bottles filled with {}", liquidType.getName());
    }
}