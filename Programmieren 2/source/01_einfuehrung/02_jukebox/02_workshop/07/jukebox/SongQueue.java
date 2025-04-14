package jukebox;

import shared.Song;

import java.util.LinkedList;
import java.util.Queue;

public class SongQueue {
    private final Queue<Song> songs = new LinkedList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Song getNextSong() {
        return songs.poll();
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }
}