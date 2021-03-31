package org.example.java11.misc.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> accounts = new HashMap<>();

        accounts.put(1, "NL23RABO07346937469");
        accounts.put(2, "NL12RABO04565536535");
        accounts.put(3, "NL03ABNA75346937469");
        String s = accounts.get(2);

        for (Map.Entry<Integer, String> e : accounts.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }

    }

}
