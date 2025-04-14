package shared;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Artist {
    private String name;

    // 1:n bidirectional relationship
    @Builder.Default
    private List<Song> discography = new ArrayList<>();

    public void addSong(Song song) {
        discography.add(song);
        song.setArtist(this);
    }
}