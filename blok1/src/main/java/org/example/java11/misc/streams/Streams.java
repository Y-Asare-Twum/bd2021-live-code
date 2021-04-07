package org.example.java11.misc.streams;

import org.example.java11.slides.h3.Person;

import java.util.List;
import java.util.stream.Stream;

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

        Person reduced = Stream.of(10, 20, 30, 40)
                .map(Person::new)
                .reduce(new Person(), (totalPerson, p) -> totalPerson.plus(p.getName(), p.getAge()));

        System.out.println(reduced);
    }

}
