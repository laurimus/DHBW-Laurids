import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Page {
    private final int pageNumber;
    private final String content;

    public void displayContent() {
        log.info("Page {}: {}", pageNumber, content);
    }
}