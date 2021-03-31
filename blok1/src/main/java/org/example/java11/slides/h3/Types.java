package org.example.java11.slides.h3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Types {

    public void byteDemo() {
        byte h = 0x0F; // by eight: 8 bits: 0000_0100 = 2^8 = 256
        byte b = 0b00001111;
        byte s = -128; // signed, heeft een sign, +/-

        char c = 'c';
        char d = 'd';
        char k = (char) (c + d);
        System.out.println((int) k);

        short sh = 65000 / 2;

        int i = 8346478;

        long l = 47389845466477979L;
        long l1 = 1000000000000L;
        long l2 = l * l1;

        System.out.println(l2);

        BigInteger bi = BigInteger.valueOf(47389845466477979L);
        BigInteger bi2 = BigInteger.valueOf(1000000000000L);
        BigInteger bi3 = bi.multiply(bi2);
        System.out.println(bi3.toString());

        // 1.0010101010101010111011111 * 2^-6

        float f = 47389845466456456456456378739743900000f;
        double db = 473898454664564564564563787397439000000000000000000000000000d;

        BigDecimal bedrag = BigDecimal.valueOf(0.34);

        // 2^4 = 16

        // 2^1 = 2
        // 0
        // 1

        // 2^2 = 4
        // 00
        // 01
        // 10
        // 11

        // 2^3 = 8
        // 000
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111

        // 0001
        // 0002
        // 0003
        // 0004
        // ....

        // 0000
        // 0001
        // 0010
        // 0011
        // 0100
        // ....
    }

    public void testOverflowOfBytes() {
        byte numberA = 127;
        byte numberB = 1;
        byte sum = (byte) (numberA + numberB);
        System.out.println("sum = " + sum);
    }

    public void testRefType() {
        Person p = new Person();
        p.setName("Bart");
        // p.age = 131;
        p.setAge(131);

        Person p2 = new Person();
        p2.setName("Bart");
        p2.setAge(17);

        System.out.println(p2.getName());

        System.out.println(p == p2); // waardes vergelijken
        if (p.equals(p2)) { // inhoud van twee objecten vergelijken
            System.out.println("gelijk");
            return; // jump from this method back to caller.
        } else {
            System.out.println("ongelijk");
        }

        System.out.println("Iets anders");
    }

}
