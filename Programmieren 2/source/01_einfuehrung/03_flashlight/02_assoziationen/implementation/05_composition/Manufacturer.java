import lombok.Data;

@Data
// 1:1 unidirectional association
public class Manufacturer {
    private final String name;
    private final String country;
}