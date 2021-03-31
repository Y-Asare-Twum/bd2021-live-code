package org.example.java11.slides.h10.guitarmodule;

public class Delay implements Effect {
    @Override
    public void process(StringBuilder sound) {
        if (sound.length() > 4) {
            sound.append(sound.substring(sound.length() - 4));
        }
    }
}
