package org.example.firsttaste.slides.h13;

import org.example.firsttaste.slides.h3.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {
        // Generics are a compile-time feature, meaning the type parameter is erased
        // and all generic types are implemented as type Object

        // Primitive types not allowed as generic type argument:
        // List<int> list = new ArrayList<>();

        List<Object> objectList = new ArrayList<>(Arrays.asList(new Person(), 9L, 10d, "11f")); ;

        List<Number> numberList = new ArrayList<>(Arrays.asList(5, 9L, 10d, 11f));

        List<Double> doubleList = List.of(5.3, 4.2);
        List<Long> longList = List.of(1L, 2L, 3L);
        List<Integer> integerList = List.of(5, 6, 7);

        // How to call generic methods?
        Printer p = new Printer();

        p.<Person>print(new Person());
        p.<Integer>print(42);
        p.<String>print("42");

        // Passing type argument (<..>) is optional when calling generic method
        p.print(new Person());
        p.print(42);
        p.print("42");

        // covariant: all subtypes of Number and Number itself can be used as T in List<T>, so
        // - List<Integer>,
        // - List<Long>,
        // - ...
        p.printCo(numberList);
        p.printCo(longList);
        p.printCo(integerList);
        p.printCo(doubleList);

        // contravariant: only supertypes of Number and Number itself can be passed as T in List<T>, so only
        // - List<Number> and
        // - List<Object>
        p.printContra(objectList);
        p.printContra(numberList);
    }

}
