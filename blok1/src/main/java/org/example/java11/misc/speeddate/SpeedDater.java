package org.example.java11.misc.speeddate;

import java.util.List;

public class SpeedDater {

    public static void main(String[] args) {

        List<String> tables = List.of("A", "B", "C", "D", "E");
        List<Integer> persons = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        int start = 0;
        for (String table : tables) {
            System.out.print(table + ": ");
            Integer person = persons.get(start);
            for (int j = 1; j < persons.size(); j++) {
                Integer other = persons.get((j + start) % persons.size());
                System.out.print(person + "-" + other + " ");
            }
            System.out.println();
            start += 2;
        }
    }

}


