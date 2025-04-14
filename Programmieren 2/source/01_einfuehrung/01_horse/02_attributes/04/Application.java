import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        DressageHorse totilas = new DressageHorse(Breed.DUTCH_WARMBLOOD, Gender.STALLION, "Totilas");
        totilas.setColour(Colour.BLACK);
        totilas.setHeight(175.0);
        totilas.setFEIRegistered(true);

        log.info(String.valueOf(totilas));
    }
}