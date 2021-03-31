package org.example.java11.labs.h3;

public class Shift {

    public static void shift() {

        // 1234 >>> 1 --> 0123

        // 01
        // 02
        // 03
        // 04
        // ..
        // 09
        // 10
        // 11
        // ..

        //          543210 = 2^..
        // 000111000111001

        // 1011 == 2^0 + 2^1 + 2^3 = 1 + 2 + 8 = 11

        // sign-bit (meest linker bit):
        // 0 = +
        // 1 = -

        // 12345 >> 3 = 00012

        // 10000000000000000000000000000000000000100 >> 1 = 10000000000000000000000000000000000000010
        int j = -4 >>> 1; // 1..1_1111_1100 >>> 1 --> 01..1_1111_1110
        System.out.println(j);

        // 2's complement notatie:
        // 0011 = +3 --> 1100 + 1 = 1101
        // 0010 = +2 --> 1101 + 1 = 1110
        // 0001 = +1
        // 0000 =  0
        // 1111 = -1
        // 1110 = -2
        // 1101 = -3
        // 1100 = -4

        // neg <--> pos: alle bits inverteren + 1
    }

    public static void main(String[] args) {
        shift();
    }

}
