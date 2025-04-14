import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlasticBottleCrate extends Crate<Integer> {
    public PlasticBottleCrate() {
        super();
    }

    public void displayBottleTypes() {
        log.info("crate for plastic bottles.");
    }
}