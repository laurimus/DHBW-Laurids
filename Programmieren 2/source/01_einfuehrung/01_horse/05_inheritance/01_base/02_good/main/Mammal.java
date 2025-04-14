package main;

import lombok.Data;
import shared.Colour;
import shared.Feed;
import shared.Heart;

@Data
public abstract class Mammal {
    protected final Heart heart;
    protected Colour colour;
    protected double height;

    public Mammal() {
        heart = new Heart(40);
    }

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