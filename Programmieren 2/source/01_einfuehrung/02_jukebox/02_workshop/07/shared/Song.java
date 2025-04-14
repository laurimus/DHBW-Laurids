package shared;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@Builder
public class Song {
    private String title;
    private Duration length;

    // 1:n bidirectional relationship
    private Artist artist;
}