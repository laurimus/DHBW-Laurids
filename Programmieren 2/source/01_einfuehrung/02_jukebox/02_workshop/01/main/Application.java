package main;

import jukebox.Jukebox;
import lombok.extern.slf4j.Slf4j;

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
    }
}