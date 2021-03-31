package org.example.java11.slides.h13;

import org.example.java11.slides.h3.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generics {

    // Generic Types
    // Variabel type van iets
    //  Variabele waarde: int i = 9; i = 10;
    // Iets: klasse of een methode

    // 1) gebruiken (aanroepen) van generic classes en methods
    // a) klasse:
    // normaal staat type van een field vast; als je hier in wilt kunnen varieren, zoals bijv. bij een list
    // dan kon je alleen maar Object gebruiken.
    // nadeel: je weet niet precies wat in een list mag en wat eruit komt.
    // met generics geef je wel aan wat voor type in een object van die generic class mag komen
    // b) methode: vergelijkbaar

    // 2) Hoe maak je een generic class of method?

    public static void main(String[] args) {
        new Generics().start();
    }

    private void start() {
        Object[] objects = new Object[10];
        objects[0] = 1;
        objects[1] = "1";

        Object object = objects[8];
        int length = objects.length;

        ArrayList list = new ArrayList();
        // list.add(0, 1);
        // list.add(1, "1");
        list.add(2, new Person());

        printClassic(list);

        // aanroepen/gebruiken generic classes
        List<Person> lijst = new ArrayList<>();
        // lijst.add("");
        // lijst.add(1);
        lijst.add(new Person("Jay"));

        printGeneric(lijst);

        // aanroepen generic methods:
        ArrayList<Integer> integers = new ArrayList<>(List.of(3, 2, 1));
        ArrayList<String> strings = new ArrayList<>(List.of("3", "2", "1"));
        Collections.<Integer>sort(integers);
        Collections.<String>sort(strings);

    }

    private void printClassic(List lijst) {
        for (Object o : lijst) {
            if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println(p.getName());
            }
        }
    }

    private void printGeneric(List<Person> lijst) {
        for (Person p : lijst) {
            System.out.println(p.getName());
        }
    }

}
