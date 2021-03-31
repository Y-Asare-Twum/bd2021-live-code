package org.example.java11.labs.tdd2mocking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrajectPrijsService {

    private Logger log = LoggerFactory.getLogger(TrajectPrijsService.class);

    private TrajectNaarTrajectEenhedenService es = new TrajectNaarTrajectEenhedenService();
    private TrajectEenhedenNaarPrijsService ps = new TrajectEenhedenNaarPrijsService();

    public int getTrajectPrijs(String from, String to) {
        log.debug("Getting eenheden and price...");
        int eenheden = es.getTrajectEenheden(from, to);
        int price = ps.getPriceTrajectEenheden(eenheden);

        log.debug("eenheden={} and price={} received... now calculate result...", eenheden, price);
        return eenheden * price;
    }

}
