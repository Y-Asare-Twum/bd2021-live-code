package org.example.java11.misc.concurrency;

import org.example.java11.slides.h3.Person;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                p.haveBirthday();
            }

            System.out.println(Thread.currentThread().getId() + " done.");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                p.haveBirthday();
            }
            System.out.println(Thread.currentThread().getId() + " done.");
        });

        t1.start();
        t2.start();

        t1.join(); // wait, blocks
        t2.join();

        int age = p.getAge();
        System.out.println(age);
    }

}
