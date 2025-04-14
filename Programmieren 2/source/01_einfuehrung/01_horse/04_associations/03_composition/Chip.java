import lombok.Data;

import java.util.UUID;

@Data
public class Chip {
    private final String uuid = UUID.randomUUID().toString();
}