package org.example.java11.slides.h4;

public class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Opening MyResource...");
    }

    public String read() {
        return "Hello world!";
    }

    @Override
    public void close() {
        System.out.println("Closing MyResource...");
    }
}
