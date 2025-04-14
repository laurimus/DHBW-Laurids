package main;

import lombok.extern.slf4j.Slf4j;
import shared.*;

@Slf4j
public class Application {
    public static void main(String... args) {
        DressageHorse totilas = new DressageHorse(Breed.DUTCH_WARMBLOOD, Gender.STALLION, "Totilas");
        totilas.setColour(Colour.BLACK);
        totilas.setHeight(175.0);
        totilas.setFEIRegistered(true);
        totilas.setChip(new Chip());
        totilas.addOwner("Paul Schockemöhle");
        log.info(String.valueOf(totilas));

        totilas.move(MovementMode.WALK);
        totilas.piaffe();
        totilas.passage();
        totilas.pirouette();

        log.info("-");

        Jumper goldFever = new Jumper(Breed.GERMAN_WARMBLOOD, Gender.STALLION, "Goldfever");
        goldFever.setColour(Colour.CHESTNUT);
        goldFever.setHeight(168.0);
        goldFever.setFEIRegistered(true);
        goldFever.setChip(new Chip());
        goldFever.addOwner("Ludger Beerbaum");
        log.info(String.valueOf(goldFever));

        goldFever.move(MovementMode.GALLOP);
        goldFever.canter();
        goldFever.jump();
        goldFever.bascule();
    }
}