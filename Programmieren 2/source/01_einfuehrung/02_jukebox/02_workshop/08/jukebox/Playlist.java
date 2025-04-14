package jukebox;

import lombok.Builder;
import shared.Song;

import java.util.HashSet;
import java.util.Set;

@Builder
public class Playlist {
    private String name;

    // n:m bidirectional relationship
    @Builder.Default
    private Set<Song> songs = new HashSet<>();

    public void addSong(Song song) {
        songs.add(song);
        song.getPlaylists().add(this);
    }
}