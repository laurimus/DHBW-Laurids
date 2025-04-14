package tcas;

import lombok.extern.slf4j.Slf4j;
import shared.Aircraft;

@Slf4j
public class TrafficCollisionAvoidanceSystem implements ITrafficCollisionAvoidanceSystem {
    public void detectAndResolveConflict(Aircraft aircraft01, Aircraft aircraft02) {
        double altitudeDifference = Math.abs(aircraft01.getAltitude() - aircraft02.getAltitude());
        double distance = calculateDistance(aircraft01, aircraft02);

        if (altitudeDifference < 1000 && distance < 5) { // conflict threshold
            log.warn("conflict detected between {} and {}.", aircraft01.getId(), aircraft02.getId());
            resolveConflict(aircraft01, aircraft02);
        } else {
            log.info("no conflict detected between {} and {}.", aircraft01.getId(), aircraft02.getId());
        }
    }

    private double calculateDistance(Aircraft aircraft01, Aircraft aircraft02) {
        double latitude01 = Math.toRadians(aircraft01.getLatitude());
        double longitude01 = Math.toRadians(aircraft01.getLongitude());
        double latitude02 = Math.toRadians(aircraft02.getLatitude());
        double longitude02 = Math.toRadians(aircraft02.getLongitude());

        double deltaLatitude = latitude02 - latitude01;
        double deltaLongitude = longitude02 - longitude01;

        double a = Math.pow(Math.sin(deltaLatitude / 2), 2) +
                Math.cos(latitude01) * Math.cos(latitude02) * Math.pow(Math.sin(deltaLongitude / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371 * c;
    }

    private void resolveConflict(Aircraft aircraft01, Aircraft aircraft02) {
        if (aircraft01.getAltitude() < aircraft02.getAltitude()) {
            aircraft01.setAltitude(aircraft01.getAltitude() - 500); // descend
            aircraft02.setAltitude(aircraft02.getAltitude() + 500); // climb
        } else {
            aircraft01.setAltitude(aircraft01.getAltitude() + 500); // climb
            aircraft02.setAltitude(aircraft02.getAltitude() - 500); // descend
        }
        log.info("conflict resolved: {} now at {} ft, {} now at {} ft",
                aircraft01.getId(),
                aircraft01.getAltitude(),
                aircraft02.getId(),
                aircraft02.getAltitude());
    }
}