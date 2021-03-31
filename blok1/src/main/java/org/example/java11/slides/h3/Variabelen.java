package org.example.java11.slides.h3;

public class Variabelen {

    // STATE (field)
    String tekst; // field, class scope variable, ...; default waarde == null
    int getalletje; //                                                == 0
    boolean bool;   // false

    // BEHAVIOUR (methods)
    public void lokaal() {
        boolean voorwaarde; // null, void, ..?

        voorwaarde = true;

        System.out.println(voorwaarde);

        this.lokaal2(); // this == huidige instantie van deze class

    }

    public void lokaal2() {

        int getal = 9;

        System.out.println(getal);
        System.out.println(tekst);
        System.out.println(getalletje);
        System.out.println(bool);

    }

    //// ------------------------------------------------------------
    public static void doeIets() {
        char one = '1';
        char two = '2';
        StringBuilder sb = new StringBuilder();
        sb.append(one);
        sb.append(two);
        sb.append("");
        System.out.println(sb.toString());

        System.out.println(one + two + "" + '3');
        System.out.println(one + two + "");

        int g = 10;
        // g. // dereference operator not allowed on primitives

        Integer getal = 10; // auto boxing
        Integer getal2 = Integer.valueOf(20); // boxing

        int unboxed = getal2;

        String honderd = "100";
        int honderdAlsInt = Integer.parseInt(honderd);
        int resultaat = honderdAlsInt * 3;

        String getalTekst = getal.toString();

        String s = String.valueOf(getal);
        String s2 = getal + "";

    }

}
