package org.example.java11.slides.h6;

import org.example.java11.slides.h3.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDemo {
    // C+S+ - collapse all
    // C+S+ + expand all
    public static void main(String[] args) {
        // C+- collapse (current)

        // basics();
        // sameWithArrayList();
        // arrayOfObjects();
        // multi1();
        multi2();
        // varArgs();
    }

    private static void basics() {
        int[] getallen = {0, 1, 2, 3, 4, 6};

        // or:
        // int[] getallen = new int[10]; // index van 0 tot en met 9

        getallen[0] = 1;
        getallen[4] = 56;

        int i = getallen[1];
        int j = getallen[4];
        System.out.println(i);
        System.out.println(j);

        int length = getallen.length;

        // looping through array:
        for (int counter = 0; counter < getallen.length; counter++) {
            int item = getallen[counter];
            System.out.println(item);
        }
        // or:
        for (int item : getallen) {
            System.out.println(item);
        }
    }

    private static void sameWithArrayList() {
        ArrayList<Integer> getallenLijst = new ArrayList<>(); // size?
        getallenLijst.add(1);
        getallenLijst.add(2);
        getallenLijst.add(3);
        getallenLijst.add(4);
        getallenLijst.add(6);

        getallenLijst.set(4, 56);

        int size = getallenLijst.size();

        for (Integer item : getallenLijst) {
            System.out.println(item);
        }
    }

    private static void arrayOfObjects() {
        Person[] personen = new Person[40];
        personen[9] = new Person();
        // personen[19] = 45;  // NOK

        Person person = personen[1];
        System.out.println(person);
    }

    private static void multi1() {
        int[][] table = {
                {0, 2, 3},
                {8, 2, 5},
                {8, 2, 5},
                {2, 8, 5}
        };

        table[0][2] = 1000;
        table[1] = new int[]{18, 12, 15};

        System.out.println(table.length * table[2].length);
        show(table);
    }

    private static void show(int[][] table) {
        System.out.println("Printing array...:");
        System.out.println(table);
        System.out.println(table[0]);
        System.out.println(table[0][2]);
        System.out.println(Arrays.toString(table));  // utility class
        System.out.println(Arrays.toString(table[0]));
    }

    private static void multi2() {
        int[][] grid = new int[5][];    // @..? and initial value?
        grid[0] = new int[]{1, 2, 3};   // @..?
        int j = 89;                     // @..?
        grid[1] = new int[]{10, 20, 30};// @..?
        Integer h = 99;                 // @..?
        grid[2] = new int[]{4, 5, 6};   // @..?

        System.out.println(Arrays.toString(grid));
        System.out.println(Arrays.toString(grid[0]));
    }

    private static void varArgs() {
        System.out.println("printVarArgs and printArray");
        printVarArgs(1, 2, 3, 5, 6);
        printVarArgs(1, 2);
        printVarArgs(1, 2, 454, 2323);

        printArray(new int[]{1, 2, 3, 5, 6});
        printArray(new int[]{1, 2});
        printArray(new int[]{1, 2, 454, 2323});
    }

    public static void printVarArgs(int... getallen) { // var length param list
        for (int i : getallen) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void printArray(int[] getallen) { // var length param list
        for (int i : getallen) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
