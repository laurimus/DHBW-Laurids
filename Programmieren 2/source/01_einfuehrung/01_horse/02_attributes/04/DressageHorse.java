import lombok.Data;

@Data
public class DressageHorse {
    private final Breed breed;
    private final Gender gender;
    private final String name;
    private Colour colour;
    private double height;
    private boolean isFEIRegistered = false;

    public void setHeight(double height) {
        if (height > 75 && height <= 220) {
            this.height = height;
        }
    }
}