package main;

import lombok.extern.slf4j.Slf4j;
import shared.*;

@Slf4j
public class Application {
    public static void main(String... args) {
        DressageHorse totilas = DressageHorse.builder()
            .breed(Breed.DUTCH_WARMBLOOD)
            .gender(Gender.STALLION)
            .name("Totilas")
            .colour(Colour.BLACK)
            .height(175.0)
            .isFEIRegistered(true)
            .chip(new Chip())
            .build();
        totilas.addOwner("Paul Schockemöhle");
        log.info(String.valueOf(totilas));

        totilas.move(MovementMode.WALK);
        totilas.piaffe();
        totilas.passage();
        totilas.pirouette();

        log.info("-");

        Jumper goldFever = Jumper.builder()
            .breed(Breed.GERMAN_WARMBLOOD)
            .gender(Gender.STALLION)
            .name("Goldfever")
            .colour(Colour.CHESTNUT)
            .height(168.0)
            .isFEIRegistered(true)
            .chip(new Chip())
            .build();
        goldFever.addOwner("Ludger Beerbaum");
        log.info(String.valueOf(goldFever));

        goldFever.move(MovementMode.GALLOP);
        goldFever.canter();
        goldFever.jump();
        goldFever.bascule();
    }
}