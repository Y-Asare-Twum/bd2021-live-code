package org.example.java11.misc.lambdas.parametrization.apples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
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
    }

}
