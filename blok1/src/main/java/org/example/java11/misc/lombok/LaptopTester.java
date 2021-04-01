package org.example.java11.misc.lombok;

import java.math.BigDecimal;

public class LaptopTester {

    public static void main(String[] args) {
        Laptop laptop = new Laptop("HP", BigDecimal.ONE);
        System.out.println(laptop);

        Laptop built = Laptop.builder().brand("Dell").cpu("Intel").cpuSpeedGHz(1.6).build();
        System.out.println(built);
    }
}
