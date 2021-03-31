package org.example.java11.slides.h4;

import java.util.List;

public class ForEachDemo {

    public void demo() {
        List<Integer> getallen = List.of(1, 2, 3, 4, 5);

        for (Integer getal : getallen) { // spreek uit: "Voor ieder getal in de collectie getallen, doe: "
            System.out.println(getal);

            if(getal == 3){
                System.out.println("Drie!");
                continue;
            }

            System.out.println("Hoi!");
        }
    }

}
