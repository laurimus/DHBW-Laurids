package jukebox;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
@ToString
public class Jukebox {
    private char idCode;
    private String name;
    private boolean powerOn;
    private short maximumVolume;
    private int currentVolume;
    private long totalSongsPlayed;
    private double totalRevenue;
    private float maintenanceCost;
    private byte flags;
    private JukeboxStatus status;
}