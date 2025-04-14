import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Terminal {
    private String terminalName;
    private Gate[] gates; // 1:n unidirectional association
}