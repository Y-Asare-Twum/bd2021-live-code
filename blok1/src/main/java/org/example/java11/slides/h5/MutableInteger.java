package org.example.java11.slides.h5;

public class MutableInteger {

    private int value;

    public MutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void inc() {
        value++;
    }
}
