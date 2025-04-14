package shared;

import jukebox.Playlist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class Song {
    private String title;
    private Duration length;

    // 1:n bidirectional relationship
    private Artist artist;

    // n:m bidirectional relationship
    @Builder.Default
    private Set<Playlist> playlists = new HashSet<>();
}