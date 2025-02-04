package org.example.java11.slides.h3;

import org.example.java11.slides.h10.game.Robot;

import java.util.concurrent.locks.ReentrantLock;

public class Person implements Comparable<Robot> { // superclass

    private final ReentrantLock lock = new ReentrantLock();

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

    public Person(Integer age) {
        this.age = age;
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

    public void haveBirthday() {
        lock.lock();
        int temp = age;
        // Thread.yield(); // sta je beurt af
        temp = age + 1;
        age = temp;
        lock.unlock();
    }

    public void haveBirthday(int i) {
        age = age + i;
    }

    @Override public int compareTo(Robot o) {
        return 0;
    }

    public Person plus(String name, int age) {
        this.name += name;
        this.age += age;
        return this;
    }

    @Override public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
