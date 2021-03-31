package org.example.java11.slides.h13;

public class BakjeGeneric<T> {
    // How to define your own generic class?

    private T inhoud;

    public T getInhoud() {
        return inhoud;
    }

    public void setInhoud(T inhoud) {
        this.inhoud = inhoud;
    }
}
