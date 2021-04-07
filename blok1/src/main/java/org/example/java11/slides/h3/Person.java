package org.example.java11.slides.h3;

import org.example.java11.slides.h10.game.Robot;

public class Person implements Comparable<Robot> { // superclass

    // public, protected, - (package private), private.

    // in this:
    protected String name; // STATE
    private Integer age = 0;

    // access modifiers: public, protected, "" (=package-private), private

    public Person() {
        // body
        name = "unknown";
    }

    public Person(String name) {
        // body
        this.name = name;
    }

    // methodes  // BEHAVIOUR

    public void setAge(int nieuweLeeftijd) {
        if (nieuweLeeftijd <= 130) {
            this.age = nieuweLeeftijd;
        }
    }

    public void setName(String nieuweName) {
        this.name = nieuweName;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public synchronized void haveBirthday() {
        int temp = age;
        Thread.yield();
        temp = age + 1;
        age = temp;
    }

    public void haveBirthday(int i) {
        age = age + i;
    }

    @Override public int compareTo(Robot o) {
        return 0;
    }

    // ...

}
