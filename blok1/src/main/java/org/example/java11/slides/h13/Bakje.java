package org.example.java11.slides.h13;

import java.util.List;

public class Bakje<T extends Number> { // type parameter declaratie, must be a number

    private T inhoud;

    public T getInhoud() {
        return inhoud;
    }

    public void setInhoud(T inhoud) {
        this.inhoud = inhoud;
    }

    public <V extends Number> String concat(V o) {
        double v = o.doubleValue();
        return inhoud.toString() + o;
    }

    public <V extends Number> void print(List<V> list) {
        // list.add(1);
        // T t = list.get(0);

    }

}
