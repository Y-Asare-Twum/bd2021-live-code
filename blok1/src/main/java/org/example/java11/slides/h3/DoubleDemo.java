package org.example.java11.slides.h3;

import java.math.BigDecimal;

public class DoubleDemo {

    public static void main(String[] args) {
        System.out.println(0.58d + 0.21d);
        System.out.println(BigDecimal.valueOf(0.58d).add(BigDecimal.valueOf(0.21d)));
    }
}
