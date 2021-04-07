package org.example.java11.misc.streams;

import org.example.java11.slides.h3.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Streams {
    public static void main(String[] args) {

        List<Integer> integerObjects = List.of(1, 2, 3, 4);
        int[] integerPrimitives = {1, 2, 3, 4};

        // 1) create: Streams of objects OR Streams of primitives ------------------------------
        Stream.of(1, 2, 3, 4)
                // integerObjects.stream()
                // Arrays.stream(integerPrimitives)
                // 2) modify ------------------------------------------------------------------
                .flatMap(i -> Stream.of(i, i))  // duplicate elements, flatten two streams to one
                .skip(3)
                .sorted()
                .limit(3)
                .distinct()
                // .map(i -> i * 2)
                // .mapToInt(i -> i.intValue())     // stream of objects -> stream of primitives
                // .mapToObj(age -> new Person(age))// stream of primitives -> stream of objects
                // .mapToObj(i -> Integer.valueOf(i))
                // .boxed()
                // .filter(i -> i > 4)
                // 3)  reduce (terminal) ------------------------------------------------------
                // .reduce(0, (previous, current) -> previous - current); // folding
                // .reduce(integers, (a, b) -> {integers.add(a); return b;});
                // .collect(Collectors.partitioningBy(p -> p.getAge() > 18))
                // .collect(Collectors.groupingBy(Person::getAge))
                // .collect(Collectors.toList())
                .forEach(System.out::println) // method reference
        ;

        // van leeftijden naar personen naar één eindpersoon:
        Person reduced = Stream.of(10, 20, 30, 40)
                .map(Person::new)
                .reduce(new Person(), (totalPerson, p) -> totalPerson.plus(p.getName(), p.getAge()));

        System.out.println(reduced);

        // van leeftijden naar personen naar een lijst met "zelf" collecten:
        List<Person> collect = Stream.of(10, 20, 30, 40)
                .map(Person::new)
                .collect(
                        () -> new ArrayList<>(), // generator voor nieuwe lege lijst van persons
                        (people, p) -> people.add(p),  // wat hij elk stapje moet doen met de lijst en een person
                        (chunk1, chunk2) -> chunk1.addAll(chunk2) // wat hij moet doen om twee lijsten te combineren bij parallel processing
                );

        // idem, refactored
        List<Person> collectRefactored = Stream.of(10, 20, 30, 40)
                .map(Person::new)
                .collect(
                        ArrayList::new,     // generator voor initiële lege lijst van persons
                        ArrayList::add,     // wat hij elk stapje moet doen met de lijst en een person
                        ArrayList::addAll   // wat hij moet doen om twee lijsten te combineren bij parallel processing
                );

        // idem met collect(toList()):
        List<Person> collect2 =
                Stream.of(10, 20, 30, 40)
                        .map(Person::new)
                        .collect(toList());
    }

}
