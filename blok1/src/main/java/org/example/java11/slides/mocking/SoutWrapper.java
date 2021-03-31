package org.example.java11.slides.mocking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoutWrapper {

    private Logger log = LoggerFactory.getLogger(SoutWrapper.class);

    public void print(String m) {
        log.debug("printing....");
        System.out.print(m);
    }

    public void println(String m) {
        System.out.println(m);
    }

    public String doeIets(int i) {
        return "iets " + i;
    }

}
