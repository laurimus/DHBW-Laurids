package main;

import shared.Aircraft;
import tcas.TrafficCollisionAvoidanceSystem;

public class Application {
    public static void main(String... args) {
        TrafficCollisionAvoidanceSystem tcas = new TrafficCollisionAvoidanceSystem();

        Aircraft aircraft01 = Aircraft.builder()
                .id("AAL123")
                .altitude(35000)
                .latitude(34.0522)
                .longitude(-118.2437)
                .verticalSpeed(0)
                .build();

        Aircraft aircraft02 = Aircraft.builder()
                .id("UAL456")
                .altitude(35500)
                .latitude(34.0522)
                .longitude(-118.2437)
                .verticalSpeed(0)
                .build();

        tcas.detectAndResolveConflict(aircraft01, aircraft02);
    }
}