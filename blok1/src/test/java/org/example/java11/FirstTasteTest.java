package org.example.java11;

import org.example.java11.misc.firsttaste.FirstTaste;
import org.junit.Before;
import org.junit.Test;

// Junit4 in Junit5 project
public class FirstTasteTest {

    FirstTaste ft1;

    @Before
    public void init() {
        ft1 = new FirstTaste();
    }

    @Test
    public void testDoeIets() {
        ft1.doeIets();
    }

    @Test
    public void testDoeIetsAnders() {
        ft1.doeIetsAnders();
    }

}
