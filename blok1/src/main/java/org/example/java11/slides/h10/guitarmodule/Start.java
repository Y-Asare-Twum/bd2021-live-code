package org.example.java11.slides.h10.guitarmodule;

public class Start {

    public static void main(String[] args) {
        new Start().run();
    }

    private void run() {
        Roland td13 = new Roland();

        td13.register(new Distortion());
        td13.register(new Delay());
        td13.register(new Reverb());
        td13.register(new Delay());
        td13.register(new Distortion());
        td13.register(new Horn());
        td13.register(new Phaser());

        // local class
        td13.register(denoiser());

        // anonymous class 1 (since implementation has no name)
        Effect anonymous = new Effect() {
            @Override
            public void process(StringBuilder sound) {
                sound.append("Anonymous");
            }
        };
        td13.register(anonymous);

        // anonymous class 2
        td13.register(new Effect() {
            @Override public void process(StringBuilder sound) {
                sound.append("Super anonymous");
            }
        });

        // lambda
        td13.register(sound -> sound.append("λ"));

        td13.start("Vader Jacob");
    }

    public Effect denoiser() {
        // local class:
        class DeNoiser implements Effect {
            @Override
            public void process(StringBuilder sound) {
                String noNoise = sound.toString().replace("~~~", "");
                sound.replace(0, sound.length(), noNoise);
            }
        }

        return new DeNoiser();
    }

    public int tweeDingen(int a, int b) {
        class TweeDingen {
            int x;
            int y;

            int sum() {
                return x + y;
            }

            int product() {
                return x * y;
            }
        }

        TweeDingen tweeDingen = new TweeDingen();

        tweeDingen.x = a;
        tweeDingen.y = b;

        int sum = tweeDingen.sum();
        int pro = tweeDingen.product();

        return sum + pro;

    }

}
