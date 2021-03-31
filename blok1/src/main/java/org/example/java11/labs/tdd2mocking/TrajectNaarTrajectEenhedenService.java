package org.example.java11.labs.tdd2mocking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TrajectNaarTrajectEenhedenService {

    private final Logger log = LoggerFactory.getLogger(TrajectNaarTrajectEenhedenService.class);

    public int getTrajectEenheden(String from, String to) {
        log.debug("go to database for {} and {} and.....", from, to);
        return new Random().nextInt(10);
    }
}
