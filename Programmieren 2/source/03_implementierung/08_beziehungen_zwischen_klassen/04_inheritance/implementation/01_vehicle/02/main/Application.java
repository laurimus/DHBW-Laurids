package main;

import lombok.extern.slf4j.Slf4j;
import vehicle.FuelType;
import vehicle.Vehicle;
import vehicle.bike.BikeType;
import vehicle.bike.Motorcycle;
import vehicle.bus.Bus;
import vehicle.car.Car;
import vehicle.car.TransmissionType;
import vehicle.truck.Truck;

@Slf4j
public class Application {
    public static void main(String... args) {
        Car car = Car.builder()
                .make("Toyota")
                .model("Camry")
                .year(2022)
                .fuelType(FuelType.PETROL)
                .numberOfDoors(4)
                .isConvertible(false)
                .transmissionType(TransmissionType.AUTOMATIC)
                .build();

        Bus bus = Bus.builder()
                .make("Volvo")
                .model("B8R")
                .year(2021)
                .fuelType(FuelType.DIESEL)
                .passengerCapacity(50)
                .isDoubleDecker(true)
                .routeNumber("Route 101")
                .build();

        Truck truck = Truck.builder()
                .make("Ford")
                .model("F-150")
                .year(2023)
                .fuelType(FuelType.DIESEL)
                .cargoCapacity(2000.5)
                .is4x4(true)
                .cargoType("construction materials")
                .build();

        Motorcycle motorcycle = Motorcycle.builder()
                .make("Harley-Davidson")
                .model("Street 750")
                .year(2020)
                .fuelType(FuelType.PETROL)
                .hasSideCar(false)
                .bikeType(BikeType.CRUISER)
                .build();

        Vehicle[] vehicles = {car, bus, truck, motorcycle};
        for (Vehicle vehicle : vehicles) {
            log.info("\n--- vehicle details --- {}", vehicle);
            vehicle.startEngine();
            vehicle.stopEngine();
        }
        log.info("---");

        car.startEngine(5);
        log.info("---");

        car.startEngine(true);
        log.info("---");

        bus.announceRoute();
        log.info("---");

        truck.loadCargo("steel beams");
        log.info("---");

        motorcycle.wheelie();
    }
}