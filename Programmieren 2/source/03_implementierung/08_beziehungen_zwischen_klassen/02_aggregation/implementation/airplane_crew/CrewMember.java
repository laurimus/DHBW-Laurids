import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public abstract class CrewMember {
    private final String name;
    private final int yearsOfExperience;
}