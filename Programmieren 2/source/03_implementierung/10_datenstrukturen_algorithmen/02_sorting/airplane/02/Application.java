import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Application {
    public static void main(String... args) {
        List<Airplane> airplanes = new ArrayList<>();

        airplanes.add(new Airplane(73412, "AB123", LocalDate.of(2020, 5, 1), Carrier.LUFTHANSA));
        airplanes.add(new Airplane(91289, "CD456", LocalDate.of(2021, 8, 15), Carrier.QANTAS));
        airplanes.add(new Airplane(68938, "EF789", LocalDate.of(2022, 2, 10), Carrier.QATAR));
        airplanes.add(new Airplane(98765, "GH012", LocalDate.of(2018, 12, 5), Carrier.EMIRATES));
        airplanes.add(new Airplane(53317, "IJ345", LocalDate.of(2019, 7, 20), Carrier.QANTAS));
        airplanes.add(new Airplane(42259, "KL678", LocalDate.of(2020, 3, 18), Carrier.LUFTHANSA));
        airplanes.add(new Airplane(18470, "MN901", LocalDate.of(2021, 10, 10), Carrier.QATAR));
        airplanes.add(new Airplane(46951, "OP234", LocalDate.of(2022, 6, 1), Carrier.EMIRATES));
        airplanes.add(new Airplane(67870, "QR567", LocalDate.of(2021, 9, 15), Carrier.QANTAS));
        airplanes.add(new Airplane(34991, "ST890", LocalDate.of(2020, 4, 9), Carrier.LUFTHANSA));

        airplanes.sort(AirplaneComparator.COMPLEX_COMPARATOR);
        airplanes.forEach(airplane -> log.info(airplane.toString()));
    }
}