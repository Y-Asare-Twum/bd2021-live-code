package org.example.java11.misc.lambdas.parametrization.apples.elaborated;

import org.example.java11.misc.lambdas.parametrization.apples.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFinderElaborated {

    public static List<Apple> findGreenApples(List<Apple> apples) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equalsIgnoreCase(apple.getColor())) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

    public static List<Apple> findApples(List<Apple> apples, String color, Integer weightMin) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (color != null && color.equalsIgnoreCase(apple.getColor())) {
                listOfApples.add(apple);
            } else if (weightMin != null && apple.getWeight() >= weightMin) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

    public static List<Apple> findApplesByPredicate(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

}


