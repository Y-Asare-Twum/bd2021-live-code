package org.example.java11.slides.h10.guitarmodule;

@FunctionalInterface
public interface Effect {
    // closed for modification
    void process(StringBuilder sound); // input = een StringBuilder; output = void
    //void process(StringBuilder sound, int i); // input = een StringBuilder; output = void

    // open for extension through implements and register on roland
}
