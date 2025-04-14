import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoppingCenter {
    private final String location;
    private final Car[] parkingSpace;

    public ShoppingCenter(String location, int parkingCapacity) {
        this.location = location;
        parkingSpace = new Car[parkingCapacity];
    }

    public void park(int position, Car car) {
        log.info("car {} is parking at position {}", car.getId(), position);
        parkingSpace[position] = car;
    }

    public void freeParkingPosition(int position) {
        log.info("car from position {} is leaving", position);
        parkingSpace[position] = null;
    }

    public void report() {
        log.info("--- ShoppingCenter ({}) | Parking Space ---", location);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < parkingSpace.length; i++) {
            stringBuilder.append("[").append(i).append("] ");

            if (parkingSpace[i] != null) {
                stringBuilder.append(parkingSpace[i].getId()).append(" ");
            } else {
                stringBuilder.append("- ");
            }
        }

        log.info(stringBuilder.toString());
    }
}