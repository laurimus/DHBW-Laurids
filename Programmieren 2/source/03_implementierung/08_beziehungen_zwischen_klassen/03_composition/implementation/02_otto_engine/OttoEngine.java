import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
@ToString
public class OttoEngine {
    private final int numberOfCylinders;
    private final FuelInjector fuelInjector;
    private final Cylinder[] cylinders;
    private boolean running;
    private int totalCycles;

    public OttoEngine(int numberOfCylinders, String fuelType) {
        this.numberOfCylinders = numberOfCylinders;
        fuelInjector = new FuelInjector(fuelType);
        cylinders = new Cylinder[numberOfCylinders];
        for (int i = 0; i < numberOfCylinders; i++) cylinders[i] = new Cylinder(i + 1, new Piston(i + 1));
    }

    public void start() {
        log.info("engine is starting.");
        running = true;
        new Thread(this::runCycle).start();
    }

    public void stop() {
        running = false;
        log.info("engine stopped.");
    }

    private void runCycle() {
        Random random = new Random();
        while (running) {
            log.info("\nrunning engine cycle.");
            for (Cylinder cylinder : cylinders) {
                if (!fuelInjector.injectFuel(random.nextDouble(2.0) + 0.5)) {
                    stop();
                    return;
                }
                cylinder.performCycle();
            }
            log.info("total engine cycles completed: {}", ++totalCycles);
            if (fuelInjector.getFuelLevel() < 5) log.warn("low fuel warning. refuel soon.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                stop();
            }
        }
    }
}