package org.example.java11.slides.h13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Printer {
    // How to define your own generic methods?

    public <T> void print(T t) {
        System.out.println(t);
    }

    public <T> void print(List<T> list) { // list is read (object) only
        // list.add(1.0d); // NOT allowed, since you never know what T can be, it can be anything
        for (Object t : list) { // can be anything, so object
            System.out.println(t);
        }
    }

    // invariant
    public void printNumbers(List<Number> list) { // list is read and write
        list.add(1.0d); // allowed, since Double is a subtype of Number
        System.out.println(list);
    }

    // covariant, but dangerous,
    public void printNumbers(Number[] array) { // list is read and write
        array[0] = 1.0d; // allowed, since Double is a subtype of Number
        System.out.println(Arrays.toString(array));
    }

    // Co and contravariant: -----------------------------------
    // Producer Extends, Consumer Super (PECS)

    // Extends = producer = read only, no write.
    // type parameter declaratie, must "be a" number
    public <N extends Number> void printCo(List<N> list) { // list is read (Number) only
        // list.add(1); // adding not allowed when T extends ...
        N n = list.get(0);
        for (N item : list) {
            System.out.println(item.intValue());
        }
    }

    // Super = consumer = write (and read).
    // ? must be number or object, so allowed args are: List<Object> and List<Number>
    public void printContra(List<? super Number> list) { // list is writable
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

