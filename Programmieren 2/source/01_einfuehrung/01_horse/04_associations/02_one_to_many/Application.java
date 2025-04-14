import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        DressageHorse totilas = new DressageHorse(Breed.DUTCH_WARMBLOOD, Gender.STALLION, "Totilas");
        totilas.setColour(Colour.BLACK);
        totilas.setHeight(175.0);
        totilas.setFEIRegistered(true);

        totilas.setChip(new Chip());

        // methods

        totilas.eat(Feed.HAY);

        totilas.move();
        totilas.move(MovementMode.WALK);
        totilas.move(MovementMode.TROT);
        totilas.move(MovementMode.GALLOP);

        totilas.sleep();

        totilas.addOwner("Cees Visser");
        totilas.addOwner("Tosca Visser");
        log.info(String.valueOf(totilas));

        totilas.removeOwner("Cees Visser");
        totilas.removeOwner("Tosca Visser");
        totilas.addOwner("Paul Schockemöhle");
        log.info(String.valueOf(totilas));
    }
}