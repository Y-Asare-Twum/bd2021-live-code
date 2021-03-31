package org.example.java11.slides.h10.game;

import org.example.java11.slides.h10.game.thirdparty.Plane;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        // Character c = new Animal("X");
        // System.out.println(c.toString()); // most specific impl. is used; dynamic binding
        // c = new Robot("Y");
        // System.out.println(c.toString()); // most specific impl. is used; dynamic binding

        // while (true) {
        new App().start();
        // }
    }

    private void start() throws InterruptedException {
        System.out.println("Welcome to horse races with characters!");
        System.out.print("Which player do you think will win (1-6)? ");

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println("You bet on " + s);
        System.out.println("Starting race....");

        Thread.sleep(1000);

        List<Renderable> characters = List.of(new MyChar(), new Animal("Bobby"), new Cop("Harry", 200), new Robot("C3PO"), new Animal("Cat"), new Plane("747"), new Tank("LEO"));

        int frame = 0;
        while (frame < 10) {
            System.out.println();
            for (Renderable character : characters) {
                character.move(new Random().nextInt(10));
                System.out.println(character.showMe());
            }
            Thread.sleep(500);

            // newFeature(characters);

            frame++;
        }

        System.out.println("Finish!");
        Renderable winner = characters.stream()
                .max(Comparator.comparing(Renderable::getPosition)).get();

        System.out.println(winner + " won the race!");

        if (characters.get(Integer.parseInt(s) - 1).equals(winner)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }

    }

    private void newFeature(List<Renderable> characters) {
        for (Renderable character : characters) {
            if (character instanceof Enemy) {
                Enemy e = (Enemy) character;
                e.eat();
            }
        }
    }

}
