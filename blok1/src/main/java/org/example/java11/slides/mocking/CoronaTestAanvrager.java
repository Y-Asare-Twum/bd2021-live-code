package org.example.java11.slides.mocking;

import org.slf4j.Logger; // slf4j = Simple Logging Facade for Java = API = interfaces
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.temporal.ChronoUnit.DAYS;

public class CoronaTestAanvrager {

    private Logger log = LoggerFactory.getLogger(CoronaTestAanvrager.class);

    private ScannerWrapper scanner = new ScannerWrapper();
    private SoutWrapper sout = new SoutWrapper();

    public void start() {
        log.info("Info ....");
        log.warn("Warning ....");
        log.debug("Starting ....");
        log.error("Fout!");

        sout.print("Wat is uw BSN? ");
        String input = scanner.nextLine();
        sout.println(showBSN(input));
        LocalDateTime tomorrow = now().plus(1, DAYS);
        sout.println("Uw test is gepland op: " + tomorrow);
    }

    public String doeIetsMetSoutWrapper(int i) {
        return sout.doeIets(i * 2);
    }

    String showBSN(String input) {
        return "Uw BSN is: " + input;
    }
}
