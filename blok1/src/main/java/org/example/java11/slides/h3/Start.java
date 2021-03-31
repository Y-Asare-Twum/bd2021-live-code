package org.example.java11.slides.h3;

public class Start {

    public static void main(String[] args) {
        // class == template van iets; ontwerp, een blauwdruk
        Variabelen varia1 = new Variabelen(); // object == instantie van een class
        Variabelen varia2 = new Variabelen(); // new == constructor
        Variabelen varia3 = new Variabelen();

        // varia1.lokaal2();
        // varia1.lokaal2();
        // varia3.lokaal2();
        // varia2.lokaal2();

        Variabelen.doeIets();

        Person thomas = new Person();
        Person bram = new Person("Janssens");


        System.gc();

    }

}
