package org.example.java11.slides.h10.guitarmodule;

import org.example.java11.slides.h10.guitarmodule.randomeffects.AutoTuner;

public class RolandBadDesign {

    private Reverb reverb = new Reverb();
    private Distortion distortion = new Distortion();
    private Delay delay = new Delay();
    private AutoTuner tuner = new AutoTuner();

    StringBuilder sound = new StringBuilder();

    public void start(String inputSound) {
        sound.append(inputSound);

        reverb.process(sound);
        distortion.process(sound);
        delay.process(sound);
        tuner.tune(); // internals known?

        play();
    }

    private void play() {
        System.out.println(sound);
    }

}
