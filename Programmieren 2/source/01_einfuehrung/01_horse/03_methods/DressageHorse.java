import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class DressageHorse {
    private final Breed breed;
    private final Gender gender;
    private final String name;
    private Colour colour;
    private double height;
    private boolean isFEIRegistered = false;

    public DressageHorse(Breed breed, Gender gender, String name) {
        this.breed = breed;
        this.gender = gender;
        this.name = name;
    }

    public void setHeight(double height) {
        if (height > 75 && height <= 220) {
            this.height = height;
        }
    }

    // methods

    public void eat(Feed feed) {
        log.info("dressage horse '{}' is eating {}", name, feed.toString().toLowerCase());
    }

    public void move() {
        log.info("dressage horse '{}' walks", name);
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
}