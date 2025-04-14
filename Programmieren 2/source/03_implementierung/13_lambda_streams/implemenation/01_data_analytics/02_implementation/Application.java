import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class Application {
    private static final String CSV_FILE_PATH = "flights.csv";

    public static void main(String... args) {
        Airport jfk = getAirport();

        Predicate<Flight> highPassengerAndDelayed = flight ->
                flight.getPassengerCount() > 100 && flight.getDelayInMinutes() > 5;
        List<Flight> filteredFlights = jfk.getFlights().stream()
                .filter(highPassengerAndDelayed)
                .toList();
        log.info("flights with >100 passengers and >5 min delay: {}", filteredFlights);
        log.info("---");

        List<Flight> sortedFlights = jfk.getFlights().stream()
                .sorted(Comparator
                        .comparing(Flight::getDepartureTime)
                        .thenComparing(Comparator.comparing(Flight::getDelayInMinutes).reversed()))
                .toList();
        log.info("flights sorted by departure time and delay: {}", sortedFlights);
        log.info("---");

        Map<String, List<Flight>> flightsByDestination = jfk.getFlights().stream()
                .collect(Collectors.groupingBy(Flight::getDestination));
        log.info("flights grouped by destination: {}", flightsByDestination);
        log.info("---");

        Map<Boolean, List<Flight>> partitionedFlights = jfk.getFlights().stream()
                .collect(Collectors.partitioningBy(flight -> flight.getDelayInMinutes() > 0));
        log.info("partitioned flights (delayed vs on-time): {}", partitionedFlights);
        log.info("---");

        Predicate<Flight> destinationMatchesRegex = flight -> flight.getDestination().matches("^L.*");
        List<Flight> regexMatchedFlights = jfk.getFlights().stream()
                .filter(destinationMatchesRegex)
                .toList();
        log.info("flights with destination matching regex '^L.*': {}", regexMatchedFlights);
        log.info("---");

        Map<String, List<Flight>> combinedResult = jfk.getFlights().stream()
                .filter(flight -> flight.getPassengerCount() > 100)
                .sorted(Comparator.comparing(Flight::getDelayInMinutes).reversed())
                .collect(Collectors.groupingBy(Flight::getOrigin));
        log.info("combined filter, sort, and group: {}", combinedResult);
        log.info("---");

        Map<String, Integer> totalPassengersPerDestination = jfk.getFlights().stream()
                .collect(Collectors.groupingBy(Flight::getDestination, Collectors.summingInt(Flight::getPassengerCount)));
        log.info("total passengers per destination: {}", totalPassengersPerDestination);
        log.info("---");

        Map<String, Optional<Flight>> maxDelayPerDestination = jfk.getFlights().stream()
                .collect(Collectors.groupingBy(Flight::getDestination,
                        Collectors.maxBy(Comparator.comparing(Flight::getDelayInMinutes))));
        log.info("flight with maximum delay per destination: {}", maxDelayPerDestination);
    }

    private static Flight parseFlight(String line) {
        String[] parts = line.split(",");
        return new Flight(
                parts[0],
                parts[1],
                parts[2],
                LocalDateTime.parse(parts[3]),
                LocalDateTime.parse(parts[4]),
                Integer.parseInt(parts[5]),
                Double.parseDouble(parts[6])
        );
    }

    @SneakyThrows
    @NonNull
    private static Airport getAirport() {
        List<Flight> flights;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(CSV_FILE_PATH))) {
            flights = bufferedReader.lines()
                    .skip(1)
                    .map(Application::parseFlight)
                    .collect(Collectors.toList());
        }

        return new Airport("JFK", "John F. Kennedy International Airport", flights);
    }
}