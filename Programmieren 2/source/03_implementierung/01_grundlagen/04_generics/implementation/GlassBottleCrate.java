import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlassBottleCrate extends Crate<String> {
    public GlassBottleCrate() {
        super();
    }

    public void displayBottleTypes() {
        log.info("crate for glass bottles.");
    }
}