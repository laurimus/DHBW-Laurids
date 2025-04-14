import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class DressageHorse {
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

    public DressageHorse(Breed breed, Gender gender, String name) {
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
        log.info("dressage horse '{}' is eating {}", name, feed.toString().toLowerCase());
    }

    public void move() {
        log.info("dressage Horse '{}' walks", name);
    }

    public void move(MovementMode mode) {
        switch (mode) {
            case WALK -> log.info("dressage horse '{}' walks", name);
            case TROT -> log.info("dressage horse '{}' trots", name);
            case GALLOP -> log.info("dressage horse '{}' gallops", name);
        }
    }

    public void sleep() {
        log.info("dressage horse '{}' is sleeping", name);
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