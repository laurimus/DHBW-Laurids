package main;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
public class DressageHorse extends Horse {
    public void piaffe() {
        log.info("dressage horse '{}' executes piaffe", name);
    }

    public void passage() {
        log.info("dressage horse '{}' executes passage", name);
    }

    public void pirouette() {
        log.info("dressage horse '{}' executes pirouette", name);
    }
}