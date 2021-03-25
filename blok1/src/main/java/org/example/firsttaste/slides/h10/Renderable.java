package org.example.firsttaste.slides.h10;

public interface Renderable {

    /**
     * Should move position of implementing object
     *
     * @param i number of positions to move
     */
    void move(int i);  // WAT moet een moveable doen?

    String showMe();

    default String path(int position, String name) {
        return ">".repeat(position) + name;
    }

    int getPosition();

    String getIcon();

}
