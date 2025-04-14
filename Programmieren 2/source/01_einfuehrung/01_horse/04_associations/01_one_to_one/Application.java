public class Application {
    public static void main(String... args) {
        DressageHorse totilas = new DressageHorse(Breed.DUTCH_WARMBLOOD, Gender.STALLION, "Totilas");
        totilas.setColour(Colour.BLACK);
        totilas.setHeight(175.0);
        totilas.setFEIRegistered(true);

        totilas.setChip(new Chip());
        System.out.println(totilas);

        // methods

        totilas.eat(Feed.HAY);

        totilas.move();
        totilas.move(MovementMode.WALK);
        totilas.move(MovementMode.TROT);
        totilas.move(MovementMode.GALLOP);

        totilas.sleep();
    }
}