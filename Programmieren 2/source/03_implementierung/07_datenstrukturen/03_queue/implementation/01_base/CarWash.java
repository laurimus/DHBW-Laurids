import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class CarWash {
    private final String location;
    private final Queue<Car> queue;

    public CarWash(String location) {
        this.location = location;
        queue = new LinkedList<>();
    }

    public void registerCar(Car car) {
        queue.add(car);
        log.info(queue.toString());
    }

    public void start() {
        log.info("{} | washing car: {}", location, queue.poll());
        log.info(queue.toString());
    }
}