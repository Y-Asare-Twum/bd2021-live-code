package org.example;

public class Start {

    // start
    public static void main(String[] args) { //

        FirstTaste ft1 = new FirstTaste();
        ft1.name = "nummer 1";

        FirstTaste ft2 = new FirstTaste();
        ft2.name = "nummer 2";

        ft1.doeIets();
        ft2.doeIetsAnders();

        // FirstTaste.doeIets();           // Ctrl+D = duplicate line
        // FirstTaste.doeIetsAnders();
    }

}

