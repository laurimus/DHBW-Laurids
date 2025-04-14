import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Pilot extends CrewMember {
    private final String typeOfAircraft;
}