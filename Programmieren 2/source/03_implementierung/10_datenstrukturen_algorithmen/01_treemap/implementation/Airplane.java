import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;

@Slf4j
public class Airplane {
    private final TreeMap<String, Boolean> seats = new TreeMap<>();

    public Airplane() {
        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 1; row <= 30; row++) {
            for (char seatLetter = 'A'; seatLetter <= 'F'; seatLetter++) {
                seats.put(row + "" + seatLetter, false);
            }
        }
    }

    public void reserveSeat(String seatNumber) {
        seats.computeIfPresent(seatNumber, (key, isOccupied) -> {
            if (isOccupied) {
                log.info("seat {} is already occupied or does not exist.", seatNumber);
                return isOccupied;
            } else {
                log.info("seat {} reserved successfully.", seatNumber);
                return true;
            }
        });
        if (!seats.containsKey(seatNumber)) {
            log.info("seat {} does not exist.", seatNumber);
        }
    }

    public void cancelReservation(String seatNumber) {
        seats.computeIfPresent(seatNumber, (key, isOccupied) -> {
            if (isOccupied) {
                log.info("reservation for seat {} cancelled successfully.", seatNumber);
                return false;
            } else {
                log.info("seat {} is not occupied or does not exist.", seatNumber);
                return isOccupied;
            }
        });
        if (!seats.containsKey(seatNumber)) {
            log.info("seat {} does not exist.", seatNumber);
        }
    }

    public void printSeating() {
        log.info("--- seating ---");
        seats.forEach((seatNumber, isOccupied) -> log.info("seat {}: {}",
                seatNumber,
                isOccupied ? "occupied" : "available"));
    }
}