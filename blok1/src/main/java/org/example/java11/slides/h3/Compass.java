package org.example.java11.slides.h3;

public enum Compass {

    N("North"), E("East"), S("South"), W("West");
    // 0        1          2           3

    private final String description;

    Compass(String descr) {
        this.description = descr;
    }

    public String getDescription() {
        return this.description;
    }
}
