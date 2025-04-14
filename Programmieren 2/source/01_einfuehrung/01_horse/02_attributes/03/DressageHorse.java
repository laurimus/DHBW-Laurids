import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class DressageHorse {
    private final Breed breed;
    private final String name;
    private double height;
    private boolean isFEIRegistered = false;
    private Colour colour;

    public void setHeight(double height) {
        if (height > 75 && height <= 220) {
            this.height = height;
        }
    }
}