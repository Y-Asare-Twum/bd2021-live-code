package org.example.java11.slides.h10.game.thirdparty;

import org.example.java11.slides.h10.game.Renderable;

public class Plane implements Renderable {

    private int pos;
    private String name;

    public Plane(String name) {
        this.name = name;
    }

    @Override
    public void move(int i) {
        this.pos += i;
    }

    @Override
    public String showMe() {
        return getIcon() + path(pos, name);
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public String getIcon() {
        return "✈";
    }

    @Override
    public String toString() {
        return getIcon() + name;
    }
}
