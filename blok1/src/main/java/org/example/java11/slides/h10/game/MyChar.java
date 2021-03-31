package org.example.java11.slides.h10.game;

public class MyChar implements Renderable {

    // Bad implementation!
    @Override public void move(int i) {
        throw new UnsupportedOperationException();
    }

    @Override public String showMe() {
        throw new UnsupportedOperationException();
    }

    @Override public int getPosition() {
        throw new UnsupportedOperationException();
    }

    @Override public String getIcon() {
        throw new UnsupportedOperationException();
    }
}
