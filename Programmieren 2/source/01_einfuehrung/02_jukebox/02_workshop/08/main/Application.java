package main;

import jukebox.Jukebox;
import jukebox.JukeboxStatus;
import jukebox.Playlist;
import lombok.extern.slf4j.Slf4j;
import shared.Artist;
import shared.Song;
import utility.Utility;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String... args) {
        Artist queen = Artist.builder().name("Queen").build();
        Artist acdc = Artist.builder().name("AC/DC").build();
        Artist artefuckt = Artist.builder().name("Artefuckt").build();

        Song song01 = Song.builder().title("Bohemian Rhapsody").length(Duration.ofMinutes(5).plusSeconds(55)).build();
        Song song02 = Song.builder().title("Highway to Hell").length(Duration.ofMinutes(3).plusSeconds(28)).build();
        Song song03 = Song.builder().title("Another One Bites the Dust").length(Duration.ofMinutes(3).plusSeconds(35)).build();
        Song song04 = Song.builder().title("Artefuckt").length(Duration.ofMinutes(4).plusSeconds(53)).build();
        Song song05 = Song.builder().title("Adrenalin").length(Duration.ofMinutes(4).plusSeconds(53)).build();

        queen.addSong(song01);
        queen.addSong(song03);
        acdc.addSong(song02);
        artefuckt.addSong(song04);
        artefuckt.addSong(song05);

        Jukebox jukebox = Jukebox.builder()
                .idCode('A')
                .name("Dave's Diner Jukebox")
                .powerOn(false)
                .maximumVolume((short) 150)
                .currentVolume(85)
                .maintenanceCost(199.99f)
                .flags((byte) 0b00101101)
                .build();

        jukebox.togglePower();

        Playlist rockClassics = Playlist.builder().name("Rock Classics").build();
        Playlist eightiesHits = Playlist.builder().name("80s Mega Hits").build();

        rockClassics.addSong(song01);
        rockClassics.addSong(song02);
        eightiesHits.addSong(song03);
        rockClassics.addSong(song04);
        rockClassics.addSong(song05);

        jukebox.getPlaylists().add(rockClassics);
        jukebox.getPlaylists().add(eightiesHits);

        jukebox.addToQueue(song02);
        jukebox.addToQueue(song04);
        jukebox.addToQueue(song05);

        log.info("--- playing songs ---");
        jukebox.playNextSong();
        jukebox.playNextSong();

        jukebox.togglePower();

        log.info("\n--- maintenance ---");
        jukebox.setStatus(JukeboxStatus.MAINTENANCE);
        jukebox.setMaintenanceCost(249.99f);
        jukebox.setLastMaintenance(LocalDateTime.now());
        log.info("maintenance cost updated to: {}", Utility.formatCurrency(jukebox.getMaintenanceCost()));
        log.info(jukebox.toString());

        log.info("\n=== attempting playback during maintenance ===");
        jukebox.playNextSong();

        log.info("\n--- resuming service ---");
        jukebox.setStatus(JukeboxStatus.ACTIVE);
        jukebox.playNextSong();

        log.info("\n--- final statistics ---");
        log.info("installation date  : {}", Utility.formatDate(jukebox.getInstallationDate()));
        log.info("total songs played : {}", jukebox.getTotalSongsPlayed());
        log.info("total revenue      : {}", String.format("%.2f", jukebox.getMoneyCollector().getTotalCollected()));
        log.info("last maintenance   : {}", Utility.formatDateTime(jukebox.getLastMaintenance()));
    }
}