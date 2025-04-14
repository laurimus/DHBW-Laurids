package jukebox;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate installationDate;
    private LocalDateTime lastMaintenance;

    // composition (1:1)
    @Builder.Default
    private MoneyCollector moneyCollector = new MoneyCollector();

    public void togglePower() {
        powerOn = !powerOn;
        log.info("power on: {}", powerOn);
    }
}