package org.example.java11.slides.h10.game;

public class Tank implements Enemy, Renderable {

    private final String name;
    private int pos;

    public Tank(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("Pats boem!");
    }

    @Override
    public void move(int i) {
        pos += i;
    }

    @Override
    public String showMe() {
        return getIcon() + path(pos, name);
    }

    @Override
    public String toString() {
        return getIcon() + name;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDE97";
    }
}
