import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Bottle<T> {
    private T content;

    public Bottle(T content) {
        this.content = content;
    }
}