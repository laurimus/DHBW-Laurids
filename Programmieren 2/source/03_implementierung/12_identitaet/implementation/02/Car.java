import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@ToString
public class Car {
    private String id;
    private String brand;
}