package main;

import jukebox.Jukebox;
import jukebox.JukeboxStatus;
import lombok.extern.slf4j.Slf4j;
import utility.Utility;

import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String... args) {
        Jukebox jukebox = Jukebox.builder()
                .idCode('A')
                .name("Dave's Diner Jukebox")
                .powerOn(false)
                .maximumVolume((short) 150)
                .currentVolume(85)
                .maintenanceCost(199.99f)
                .flags((byte) 0b00101101)
                .build();

        log.info(jukebox.toString());

        log.info("\n--- maintenance ---");
        jukebox.setStatus(JukeboxStatus.MAINTENANCE);
        jukebox.setMaintenanceCost(249.99f);
        jukebox.setLastMaintenance(LocalDateTime.now());
        log.info("maintenance cost updated to: {}", Utility.formatCurrency(jukebox.getMaintenanceCost()));
        log.info(jukebox.toString());
    }
}