package org.example.java11.slides.h10.guitarmodule;

import java.util.ArrayList;
import java.util.List;

public class Roland {

    List<Effect> effects = new ArrayList<>();
    StringBuilder sound = new StringBuilder();

    public void start(String inputSound) {
        sound.append(inputSound);

        for (Effect effect : effects) {
            effect.process(sound);
        }

        play();
    }

    private void play() {
        System.out.println(sound);
    }

    public void register(Effect e) {
        effects.add(e);
    }
}
