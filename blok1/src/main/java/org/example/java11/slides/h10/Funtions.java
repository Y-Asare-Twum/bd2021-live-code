package org.example.java11.slides.h10;

import java.util.function.Function;
import java.util.function.IntFunction;

public class Funtions {

    public void demo() {

        // f(x) -> x^2
        // f(2) = 4
        // f(3) = 9

        MyFunction f = (int x) -> x * x;
        int kwadraat1 = f.execute(2); // f(2)
        int kwadraat2 = f.execute(3); // f(3)

        Function<Integer, Integer> g = a -> a + 1;
        IntFunction<Integer> g2 = a -> a + 1;
        int result1 = g2.apply(5);

        IntFunction<Integer> g3 = new IntFunction<Integer>() {
            @Override public Integer apply(int value) {
                return value + 1;
            }
        };

        int result2 = g3.apply(5);
    }

}

// met een class beschrijf je objecten
// met een interface beschrijf je gedrag (afspraak)
// met een @FunctionalInterface beschrijf je één functie

@FunctionalInterface
interface MyFunction {
    int execute(int in);
}
