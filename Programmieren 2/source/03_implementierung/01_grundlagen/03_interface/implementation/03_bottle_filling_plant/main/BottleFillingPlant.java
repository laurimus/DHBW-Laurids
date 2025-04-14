package main;

import lombok.extern.slf4j.Slf4j;
import machine.*;
import shared.Bottle;
import shared.LiquidType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class BottleFillingPlant {
    public static void main(String... args) {
        List<Bottle> bottles = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            bottles.add(Bottle.builder().id("B" + i).build());
        }

        ProductionLine line = new ProductionLine(Arrays.asList(new Unscrambler(), new Rinser(), new Filler(LiquidType.SODA), new Capper(), new Labeler(), new Packager(), new Palletizer()));
        log.info("starting bottle filling process.");
        line.run(bottles);
        log.info("process completed.");
    }
}