import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String... args) {
        Manufacturer manufacturer = new Manufacturer("BrightCo", "USA");
        Case flashlightCase = new Case("Plastic", "Black");

        Flashlight flashlight = new Flashlight('M',
                "UltraBright",
                (byte) 2,
                (short) 300,
                1000,
                123456789L,
                LocalDate.of(2023, 1, 1),
                LocalDateTime.now(),
                Mode.OFF,
                true,
                49.99,
                10.5f,
                manufacturer,
                flashlightCase);

        Battery battery01 = new Battery("AA", 1.5f);
        Battery battery02 = new Battery("AA", 1.5f);
        flashlight.addBattery(battery01);
        flashlight.addBattery(battery02);

        Project project01 = new Project("camping trip");
        Project project02 = new Project("night hike");
        flashlight.addProject(project01);
        flashlight.addProject(project02);

        log.info(String.valueOf(flashlight));
        log.info("manufacturer  : {}", flashlight.getManufacturer().getName());
        log.info("case material : {}", flashlight.getFlashlightCase().getMaterial());
        log.info("bulb type     : {}", flashlight.getBulb().getType());
        log.info("batteries     : {}", flashlight.getBatteries().size());
        log.info("projects      : {}", flashlight.getProjects().size());
    }
}