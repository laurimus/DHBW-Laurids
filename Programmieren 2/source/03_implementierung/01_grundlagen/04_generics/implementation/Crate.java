import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Crate<T> {
    private List<Bottle<T>> bottles;

    public Crate() {
        bottles = new ArrayList<>();
    }

    public void addBottle(Bottle<T> bottle) {
        bottles.add(bottle);
    }

    public int getCapacity() {
        return bottles.size();
    }
}