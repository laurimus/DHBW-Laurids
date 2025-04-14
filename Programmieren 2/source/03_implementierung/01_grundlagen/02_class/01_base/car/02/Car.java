import lombok.Data;

@Data
public class Car {
    private int serialNumber;
    private int speed;

    public void increaseSpeed() {
        if (speed < 250) {
            speed++;
        } else {
            speed = 250;
        }
    }

    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
        } else {
            speed = 0;
        }
    }

    public void stop() {
        speed = 0;
    }
}