import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Application {
    public static void main(String... args) {
        Captain captain = Captain.builder()
                .name("John Doe")
                .yearsOfExperience(20)
                .typeOfAircraft("Airbus A350-900")
                .build();

        Pilot seniorFirstOfficer = Pilot.builder()
                .name("Alice Smith")
                .yearsOfExperience(12)
                .typeOfAircraft("Airbus A350-900")
                .build();

        FlightAttendant flightAttendant = FlightAttendant.builder()
                .name("Emily Clark")
                .yearsOfExperience(2)
                .build();

        Purser purser = Purser.builder()
                .name("Sarah Lee")
                .yearsOfExperience(5)
                .build();

        FlightCrew flightCrew = FlightCrew.builder()
                .captain(captain)
                .pilots(List.of(captain, seniorFirstOfficer))
                .flightAttendant(flightAttendant)
                .purser(purser)
                .build();

        log.info(flightCrew.toString());
    }
}