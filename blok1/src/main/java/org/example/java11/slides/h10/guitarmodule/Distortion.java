package org.example.java11.slides.h10.guitarmodule;

public class Distortion implements Effect {

    @Override
    public void process(StringBuilder sound) {
        sound.append(" Roar!");
    }
}
