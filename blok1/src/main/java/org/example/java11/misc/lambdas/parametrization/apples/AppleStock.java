package org.example.java11.misc.lambdas.parametrization.apples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class AppleStock {
    private static final String[] COLORS = {"green", "red", "yellow"};
    public static int SIZE = 10;
    public static final Apple defaultApple = new Apple("UNKNOWN", -1);

    static {
        stock = DoubleStream.generate(Math::random)
                .mapToInt(r -> (int) (r * 300))
                .mapToObj(w -> new Apple(COLORS[(int) (Math.random() * 3)], w))
                .limit(SIZE)
                .toArray(Apple[]::new);
    }

    public static final Apple[] stock;

    public static Stream<Apple> appleStream() {
        return Arrays.stream(stock);
    }

    public static List<Apple> appleList() { return Arrays.asList(stock); }
}
