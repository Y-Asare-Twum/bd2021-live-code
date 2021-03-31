package org.example.java11.misc.lombok;

import java.math.BigDecimal;

public class LaptopTester {

    public static void main(String[] args) {
        Laptop laptop = new Laptop("HP", BigDecimal.ONE);
        laptop.setBrand("Dell");

        System.out.println(laptop);
        Laptop built = Laptop.builder().name("HP").build();

    }
}
