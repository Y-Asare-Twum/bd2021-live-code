package org.example.java11.misc.lambdas.parametrization.apples;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.example.java11.misc.lambdas.parametrization.apples.AppleStock.appleList;

public class AppleFinder {

    public static List<Apple> findApples(List<Apple> apples, Predicate<Apple> condition) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (condition.test(apple)) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

    public static void main(String[] args) {
        List<Apple> apples = appleList();

        int i = 1;
        String s = "string";

        Predicate<Apple> p = new Predicate<Apple>() {
            @Override public boolean test(Apple a) {
                return a.getWeight() > 150;
            }
        };

        List<Apple> apples0 = findApples(apples, p);
        List<Apple> apples1 = findApples(apples, a -> a.getWeight() > 150);
        List<Apple> apples2 = findApples(apples, a -> a.getWeight() > 150 && a.getColor().equals("red"));
        List<Apple> apples3 = findApples(apples, a -> a.getColor().equals("red"));

        List<Apple> apples4 =
                apples.stream() // 1
                        .filter(a -> a.getWeight() > 150) // 2
                        .filter(a -> a.getColor().equals("red")) // 2
                        .collect(toList()); // 3

        Stream<Apple> stream = apples.stream();

        long sum = apples.stream()
                .map(a -> {
                    System.out.println(a);
                    return a;
                })
                .mapToInt(a -> a.getWeight())
                .count();

        // stream.forEach(System.out::println); // stream has already been operated upon or closed

        // group apples by color, old style:
        Map<String, List<Apple>> groups = new HashMap<>();

        for (Apple apple : apples) {
            String color = apple.getColor();
            boolean b = groups.containsKey(color);
            if (b) {
                List<Apple> appleList = groups.get(color);
                appleList.add(apple);
            } else {
                groups.put(color, new LinkedList<>(List.of(apple)));
            }
        }

        groups.forEach((color, list) -> System.out.println(color + "=" + list));

        // new style
        Map<String, List<Integer>> groupsNewStyle = apples.stream()
                .collect(groupingBy(Apple::getColor, mapping(Apple::getWeight, toList())));

        groupsNewStyle.forEach((color, list) -> System.out.println(color + "=" + list));

        String weightCSV = apples.stream()
                .map(a -> a.getWeight() + "")
                .collect(joining(", ")); // StringJoiner sj;

        List<Integer> integers = List.of(1, 2, 3, 4);

        integers.stream()
                .map(n -> new Integer[]{n, n})
                .flatMap(ia -> Arrays.stream(ia))
                .forEach(System.out::println)
        ;

        integers.stream()
                .flatMap(n -> Stream.of(n, n))
                .flatMap(is -> Stream.of(is, is))
                // .flatMap(is -> is)
                // .flatMap(is -> is)
                .forEach(System.out::println)
        ;

        integers.stream()
                .flatMap(n -> Stream.of(n, n))
                .forEach(System.out::println)
        ;

        integers.stream() // MONAD
                .map(n -> n)
                .forEach(System.out::println)
        ;

        int getal = 1;
        // 1 --> [1,1]
        int[] getallen = {getal, getal};
    }

}
