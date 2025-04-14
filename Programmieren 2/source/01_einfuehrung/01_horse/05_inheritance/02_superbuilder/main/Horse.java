package main;

import lombok.Builder;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import shared.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SuperBuilder
public abstract class Horse extends Mammal {
    protected final Breed breed;
    protected final Gender gender;
    protected final String name;
    @Builder.Default
    protected final List<Owner> owners = new ArrayList<>();

    @Setter
    protected boolean isFEIRegistered;
    @Setter
    protected Chip chip;

    // Methods
    @Override
    public void eat(Feed feed) {
        log.info("horse '{}' is eating {}", name, feed.toString().toLowerCase());
    }

    @Override
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

    @Override
    public void sleep() {
        log.info("horse '{}' is sleeping", name);
    }

    // Owner management
    public void addOwner(String ownerName) {
        Owner owner = new Owner(ownerName);
        if (!owners.contains(owner)) {
            owners.add(owner);
        } else {
            log.info("{} already registered", owner);
        }
    }

    public void removeOwner(String ownerName) {
        Owner owner = new Owner(ownerName);
        owners.remove(owner);
    }
}