package org.example.java11.labs.tdd2mocking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        new App().startUp();
    }

    private void startUp() {
        int trajectPrijs = new TrajectPrijsService().getTrajectPrijs("Ut", "Am");
        log.info("Trajectprijs is binnen: " + trajectPrijs);
    }

}
