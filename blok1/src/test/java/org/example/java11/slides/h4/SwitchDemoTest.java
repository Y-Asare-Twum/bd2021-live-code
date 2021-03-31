package org.example.java11.slides.h4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.java11.slides.h4.SwitchDemo.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchDemoTest {

    private SwitchDemo target;

    @BeforeEach
    void setUp() {
        target = new SwitchDemo();
    }

    @Test
    void testDemoSwitchStatement() {
        assertEquals(EEN, target.demoSwitchStatement(1));
        assertEquals(TWEE, target.demoSwitchStatement(2));
        assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchStatement(3));
        assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchStatement(4));
        assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchStatement(5));

        assertEquals(IETS_ANDERS, target.demoSwitchStatement(0));
        assertEquals(IETS_ANDERS, target.demoSwitchStatement(6));
    }

    @Test
    void testDemoSwitchExpression() {
        // assertEquals(EEN, target.demoSwitchExpression(1));
        // assertEquals(TWEE, target.demoSwitchExpression(2));
        // assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchExpression(3));
        // assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchExpression(4));
        // assertEquals(DRIE_OF_VIER_OF_VIJF, target.demoSwitchExpression(5));
        //
        // assertEquals(IETS_ANDERS, target.demoSwitchExpression(0));
        // assertEquals(IETS_ANDERS, target.demoSwitchExpression(6));
    }
}

