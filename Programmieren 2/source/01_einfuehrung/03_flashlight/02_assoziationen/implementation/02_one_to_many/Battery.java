import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
// 1:n bidirectional association
public class Battery {
    private final String type;
    private final float voltage;
    @ToString.Exclude
    private Flashlight flashlight; // bidirectional association
}