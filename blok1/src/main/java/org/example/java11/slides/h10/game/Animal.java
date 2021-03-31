package org.example.java11.slides.h10.game;

import java.awt.*;

public class Animal extends Character {

    private Color color;

    public Animal(String n) {
        this(n, Color.BLACK);
    }

    public Animal(String n, Color color) {
        super(n);
        this.color = color;
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC3A";
    }
}
