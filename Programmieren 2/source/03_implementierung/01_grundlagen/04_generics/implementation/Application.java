import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        GlassBottleCrate glassCrate = new GlassBottleCrate();
        glassCrate.addBottle(new Bottle<>("Water"));
        glassCrate.addBottle(new Bottle<>("Juice"));

        PlasticBottleCrate plasticCrate = new PlasticBottleCrate();
        plasticCrate.addBottle(new Bottle<>(500));
        plasticCrate.addBottle(new Bottle<>(330));

        glassCrate.displayBottleTypes();
        log.info("glass crate capacity   : {}", glassCrate.getCapacity());
        glassCrate.getBottles().forEach(bottle -> log.info("bottle: {}", bottle));

        plasticCrate.displayBottleTypes();
        log.info("plastic crate capacity : {}", plasticCrate.getCapacity());
        plasticCrate.getBottles().forEach(bottle -> log.info("bottle: {}", bottle));
    }
}