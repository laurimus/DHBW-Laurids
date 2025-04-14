package main;

import lombok.extern.slf4j.Slf4j;
import shared.Breed;
import shared.Gender;

@Slf4j
public class DressageHorse extends Horse {
    public DressageHorse(Breed breed, Gender gender, String name) {
        super(breed, gender, name);
    }

    public void piaffe() {
        log.info("Dressage Horse '{}' executes piaffe", name);
    }

    public void passage() {
        log.info("Dressage Horse '{}' executes passage", name);
    }

    public void pirouette() {
        log.info("Dressage Horse '{}' executes pirouette", name);
    }
}