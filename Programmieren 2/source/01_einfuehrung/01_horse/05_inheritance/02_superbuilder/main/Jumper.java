package main;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
public class Jumper extends Horse {
    public void jump() {
        log.info("jumper '{}' executes jump", name);
    }

    public void bascule() {
        log.info("jumper '{}' executes bascule", name);
    }

    public void canter() {
        log.info("jumper '{}' executes canter", name);
    }
}