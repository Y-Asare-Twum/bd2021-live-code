package org.example.firsttaste.slides.h13;

import java.util.Comparator;
import java.util.List;

public class Printer {
    // How to define your own generic methods?

    public <T> void print(T t) {
        System.out.println(t);
    }

    // Co and contravariant: -----------------------------------
    // Producer Extends, Consumer Super (PECS)

    // Extends = producer = read only, no write.
    // type parameter declaratie, must "be a" number
    public <T extends Number> void printCo(List<T> list) {
        // list.add(1); // adding not allowed when T extends ...
        T t = list.get(0);
        for (T item : list) {
            System.out.println(item.intValue());
        }
    }

    // Super = consumer = write (and read).
    // ? must be number or object, so allowed args are: List<Object> and List<Number>
    public void printContra(List<? super Number> list) {
        // all numbers are allowed:
        list.add(1);
        list.add(1D);
        list.add(1F);
        list.add(1L);

        // everything else is not allowed:
        // list.add(new Object());  // not allowed: cant be done when List<Number> is passed
        // list.add("");            // not allowed; idem

        for (Object o : list) { // items are Objects
            System.out.println(o.toString());
        }

    }

    // Practical examples of using bounds:
    public <T extends Number> void copy(List<T> src, List<? super T> dest) {
        // ...
    }

    public static <T> void sort(List<? extends T> list, Comparator<? super T> comparator) {
        // sorting....
    }

}

