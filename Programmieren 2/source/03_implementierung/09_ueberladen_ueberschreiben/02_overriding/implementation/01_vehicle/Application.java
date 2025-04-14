import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = Car.builder()
                .make("BMW")
                .model("M3")
                .year(2023)
                .weight(1600)
                .maximumSpeed(250)
                .fuelCapacity(60)
                .seatingCapacity(5)
                .trunkVolume(480)
                .build();

        Truck truck = Truck.builder()
                .make("Volvo")
                .model("FH16")
                .year(2022)
                .weight(8000)
                .maximumSpeed(140)
                .fuelCapacity(400)
                .cargoCapacity(25000)
                .axles(3)
                .build();

        Motorcycle motorcycle = Motorcycle.builder()
                .make("Ducati")
                .model("Panigale V4")
                .year(2024)
                .weight(200)
                .maximumSpeed(299)
                .fuelCapacity(15)
                .hasSidecar(false)
                .build();

        car.refuel(50);
        car.accelerate(1.0);
        car.brake(20);
        log.info(String.valueOf(car));

        truck.refuel(300);
        truck.accelerate(0.8);
        truck.brake(30);
        log.info(String.valueOf(truck));

        motorcycle.refuel(10);
        motorcycle.accelerate(1.5);
        motorcycle.brake(10);
        log.info(String.valueOf(motorcycle));
    }
}