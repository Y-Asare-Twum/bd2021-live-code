package org.example.java11.slides.h10.game;

public abstract class Character implements Renderable {

    protected int position;
    protected String name;

    public Character(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return getIcon() + name;
    }

    public void move(int pos) { // HOE moet ie het doen?
        this.position += pos;
    }

    @Override
    public String showMe() {
        return getIcon() + path(position, name);
    }

    @Override
    public int getPosition() {
        return position;
    }
}
