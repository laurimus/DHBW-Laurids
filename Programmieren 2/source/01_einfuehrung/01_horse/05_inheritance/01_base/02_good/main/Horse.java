package main;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import shared.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class Horse extends Mammal {
    protected final Breed breed;
    protected final Gender gender;
    protected final String name;
    protected final List<Owner> owners;
    @Setter
    protected boolean isFEIRegistered = false;
    @Setter
    protected Chip chip;

    public Horse(Breed breed, Gender gender, String name) {
        super();
        this.breed = breed;
        this.gender = gender;
        this.name = name;
        owners = new ArrayList<>();
    }

    // methods

    public void eat(Feed feed) {
        log.info("horse '{}' is eating {}", name, feed.toString().toLowerCase());
    }

    public void move() {
        log.info("horse '{}' walks", name);
    }

    public void move(MovementMode mode) {
        switch (mode) {
            case WALK -> log.info("horse '{}' walks", name);
            case TROT -> log.info("horse '{}' trots", name);
            case GALLOP -> log.info("horse '{}' gallops", name);
        }
    }

    public void sleep() {
        log.info("horse '{}' is sleeping", name);
    }

    // owner management

    public void addOwner(String name) {
        Owner owner = new Owner(name);

        if (!owners.contains(owner)) {
            owners.add(owner);
        } else {
            log.info("{} already registered", owner);
        }
    }

    public void removeOwner(String name) {
        Owner owner = new Owner(name);
        owners.remove(owner);
    }
}