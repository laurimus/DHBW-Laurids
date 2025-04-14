package main;

import lombok.extern.slf4j.Slf4j;
import shared.Breed;
import shared.Gender;

@Slf4j
public class Jumper extends Horse {
    public Jumper(Breed breed, Gender gender, String name) {
        super(breed, gender, name);
    }

    public void jump() {
        log.info("jumper '{}' executes jump", name);
    }

    public void bascule() {
        log.info("jumper '{}' executes bascule", name);
    }

    public void canter() {
        log.info("jumper '{}' executes canter", name);
    }
}