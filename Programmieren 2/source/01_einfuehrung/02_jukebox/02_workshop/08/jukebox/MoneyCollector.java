package jukebox;

import lombok.Getter;

@Getter
public class MoneyCollector {
    private double totalCollected;

    public void collect(double amount) {
        totalCollected += amount;
    }
}