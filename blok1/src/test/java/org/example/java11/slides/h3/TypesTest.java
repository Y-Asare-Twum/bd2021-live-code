package org.example.java11.slides.h3;

import org.junit.jupiter.api.Test;

// JUnit5, maven-surefire recent version needed for maven!
public class TypesTest {

    @Test
    public void byteDemo() {
        Types t = new Types();

        t.byteDemo();
    }

    @Test
    public void testOverflow() {
        Types t = new Types();
        t.testOverflowOfBytes();
    }

    @Test
    public void testRefType() {
        Types t = new Types();
        t.testRefType();
    }
}
