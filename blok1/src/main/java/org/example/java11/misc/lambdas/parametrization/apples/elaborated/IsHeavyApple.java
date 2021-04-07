package org.example.java11.misc.lambdas.parametrization.apples.elaborated;

import org.example.java11.misc.lambdas.parametrization.apples.Apple;

class IsHeavyApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return a.getWeight() >= 150;
    }
}
