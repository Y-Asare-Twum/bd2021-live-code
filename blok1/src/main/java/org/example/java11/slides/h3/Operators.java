package org.example.java11.slides.h3;

public class Operators {

    public void demo() {

        Person bram = new Person();

        byte b = 0b0000_1111; // numerical literals
        byte invertedB = (byte) ~b; // 1101_0000

        int and = b & invertedB;

        boolean thisIsTrue = true;
        boolean whatsThis = !thisIsTrue;

        //                       0000_0000_0000_0000_0000_0000_0000_1111
        int result = b >> 3;  // 0000_0000_0000_0000_0000_0000_0000_0001
        int result2 = b << 3; // 0000_0000_0000_0000_0000_0000_0111_1000

        if (bram instanceof Person) {
            System.out.println("Het is een persoon!");
        }

        // String message = ""; // ass. statement.
        // if (result >= 0) {   // if else statement
        //     message = "POS";
        // } else {
        //     message = "NEG";
        // }

        int som = 1 + 2; // statement; doet iets en afgeloten met een ;
        // 1 + 2            expression: leidt tot een waarde, moet nog uitgerekend/geëvalueerd worden.
        String message = (result >= 0) ? "POS" : "NEG"; // assignment statement

        System.out.println(message);

        som = som + 3;
        som += 3; // hetzelfde.

        som = som + 1;
        System.out.println(som);

        int waardeVanSomVoordatHijOpgehoogdWordt = som++;
        // statement expression
        // - statement: hoog som op
        // - expression: het heeft een waarde (zoals 13+21)

        int waardeVanSomNadatHijOpgehoogdIs = ++som;

        int age = 18;
        age = age + 1;
        age += 1;
        age++;
        ++age;

        int incrementedAge = age++;

        System.out.println(age);
        System.out.println(incrementedAge);

        narrowing();

        Compass windrichting = Compass.E;

        naarNL(windrichting);

        System.out.println(windrichting);
        System.out.println(windrichting.ordinal());
        System.out.println(windrichting.getDescription());

        String n = Kompas.N;

    }

    private void narrowing() {
        int ditWordtEenByte = 0b0000_0000_0000_0000_0000_0000_1000_0000; // 2^7 = 128
        System.out.println(ditWordtEenByte);

        // 2's complement
        byte deByte = (byte) ditWordtEenByte; // 1010_0101 --> alle bits inverteren + 1
        System.out.println(deByte);

        // 1010_0101 = -91
        // 0101_1011 = +91   1+2+8+16+64=91
    }

    public void naarNL(Compass c) {
        if (c.equals(Compass.N)) {
            System.out.println("Noord");
        } else if (c.equals(Compass.E)) {
            System.out.println("Oost");
        } else if (c.equals(Compass.S)) {
            System.out.println("Zuid");
        } else if (c.equals(Compass.W)) {
            System.out.println("West");
        }

        switch (c) {
            case E:
                System.out.println("Oost2"); break;
            case N:
                System.out.println("Noord2"); break;
            default:
                System.out.println("Witnie");
        }

    }

    public static void main(String[] args) {
        Operators operators = new Operators();
        // operators.demo();
        operators.narrowing();
    }
}

