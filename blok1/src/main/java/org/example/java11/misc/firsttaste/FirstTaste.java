package org.example.java11.misc.firsttaste;

// import ...

import static java.lang.Math.abs;

// PascalCasing (begint met hoofdletter)
public class FirstTaste { // C+S+T == create test

    String name = "";

    // ....

    // public [...] <returntype> <identifier>([parameters]){
    // .. lekker programmeren!
    // }

    // camelCasing
    public void doeIets() { // methode (= functie binnen een class en objecten daarvan)
        // static and strong typed
        // static: type cannot change
        // strong: alle gegevens moeten een type hebben;
        //      nodig voor memory management (java is een managed language),
        //      handig voor programmeur

        int abs = abs(-1);

        int aantalReizigers;  // declareren, eenmalig (in de scope): <type> <identifier> ( = ...);
        aantalReizigers = 30; // waarde geven

        float perWagon = aantalReizigers / 4f; // float point, 4 is literal value

        String reizigers = "Aantal reizigers" + " is: " + aantalReizigers;
        // reizigers = "iets anders";

        System.out.println(name);
        System.out.println(reizigers); // string concatenation
        System.out.println("Aantal reizigers per wagon: " + perWagon);

        // return ...
    }

    public void doeIetsAnders() { // methode
        System.out.println(name);
        System.out.println("doeIetsAnders");
    }

}

class NogEenClass {

}
