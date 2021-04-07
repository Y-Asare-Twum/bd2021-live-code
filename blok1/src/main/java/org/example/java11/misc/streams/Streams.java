package org.example.java11.misc.streams;

import java.util.function.Function;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        Function f = input -> 1;

        Stream.of(1, 2, 3, 4)           // 1) create
                .map(i -> i * 2)        // 2) modify
                .forEach(i -> System.out.println(i)); // 3)  reduce (terminal)
    }

}
