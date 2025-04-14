package main;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import shared.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Jumper {
    private final Breed breed;
    private final Gender gender;
    private final String name;
    private final List<Owner> owners;
    private final Heart heart;
    @Setter
    private Colour colour;
    private double height;
    @Setter
    private boolean isFEIRegistered = false;
    @Setter
    private Chip chip;

    public Jumper(Breed breed, Gender gender, String name) {
        this.breed = breed;
        this.gender = gender;
        this.name = name;
        owners = new ArrayList<>();
        heart = new Heart(40);                    // composition
    }

    public void setHeight(double height) {
        if (height > 75 && height <= 220) {
            this.height = height;
        }
    }

    // composition

    public void setHeartBeatPerMinute(int count) {
        heart.setBeatsPerMinute(count);
    }

    public Heart getHeart() {
        return new Heart(heart.getBeatsPerMinute());
    }

    // methods

    public void eat(Feed feed) {
        log.info("jumper '{}' is eating {}", name, feed.toString().toLowerCase());
    }

    public void move() {
        log.info("jumper '{}' walks", name);
    }

    public void move(MovementMode mode) {
        switch (mode) {
            case WALK -> log.info("jumper '{}' walks", name);
            case TROT -> log.info("jumper '{}' trots", name);
            case GALLOP -> log.info("jumper '{}' gallops", name);
        }
    }

    public void sleep() {
        log.info("jumper '{}' is sleeping", name);
    }

    // methods only for jumper

    public void jump() {
        log.info("jumper '{}' executes jump", name);
    }

    public void bascule() {
        log.info("jumper '{}' executes bascule", name);
    }

    public void canter() {
        log.info("jumper '{}' executes canter", name);
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
