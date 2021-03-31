package org.example.java11.slides.h10.game;

public interface Enemy {

    // abstract method
    void attack();

    default void eat() {
        throw new UnsupportedOperationException("Not implemented!");
    }

}
