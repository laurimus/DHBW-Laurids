package main;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import shared.Colour;
import shared.Feed;
import shared.Heart;

@Data
@SuperBuilder
public abstract class Mammal {
    @Builder.Default
    protected final Heart heart = new Heart(40);
    protected Colour colour;
    protected double height;

    public void setHeight(double height) {
        if (height > 0) {
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
    public abstract void eat(Feed feed);
    public abstract void move();
    public abstract void sleep();
}