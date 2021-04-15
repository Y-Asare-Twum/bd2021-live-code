package org.example.java11.misc.concurrency;

import org.example.java11.slides.h3.Person;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class Demo {

    private Person p = new Person();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Demo demo = new Demo();
        demo.classicThreadAndRunnable();

        demo.threadPool();

        demo.future();
        demo.completableFuture();

        sleep(2000);
    }

    private void completableFuture() {
        supplyAsync(() -> getHaveBirthDay(10000, p))
                .thenApply(this::writeToDb)
                .thenAccept(System.out::println);

        System.out.println("completableFuture end");
    }

    private String writeToDb(Integer age) {
        System.out.println("writeToDb");
        sleep(1000);
        return "OK " + age;
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void classicThreadAndRunnable() throws InterruptedException {
        Runnable task1 = () -> haveBirthDay(5000, p);
        Runnable task2 = () -> {haveBirthDay(15000, p);};

        HaveBirthDay hb1 = new HaveBirthDay(5000, p);
        HaveBirthDay hb2 = new HaveBirthDay(15000, p);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        Thread t3 = new Thread(hb1);
        Thread t4 = new Thread(hb2);

        HaveBirthDayThread hbt = new HaveBirthDayThread(9000, p);
        hbt.start();

        t1.start();
        t2.start();

        t1.join(); // wait, blocks
        t2.join();

        int age = p.getAge();
        System.out.println(age);
    }

    private void threadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.submit(new HaveBirthDay(9000, p));
        pool.submit(new HaveBirthDay(4000, p));
        pool.submit(new HaveBirthDay(900, p));
        pool.submit(new HaveBirthDay(3000, p));
    }

    private void future() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Callable<Integer> task1 = () -> getHaveBirthDay(10000, p);
        Future<Integer> task1Result = pool.submit(task1);

        System.out.println("...");
        Thread.sleep(1000);

        Integer integer = task1Result.get();  // blocking/waiting for result

    }

    static class HaveBirthDay implements Runnable { // is een taak die door een thread opgepakt kan worden

        private final int n;
        private final Person p;

        public HaveBirthDay(int n, Person p) {
            this.n = n;
            this.p = p;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                p.haveBirthday();
            }

            System.out.println(Thread.currentThread().getId() + " done.");
        }
    }

    static class HaveBirthDayThread extends Thread {

        private final int n;
        private final Person p;

        public HaveBirthDayThread(int n, Person p) {
            this.n = n;
            this.p = p;
        }

        public void run() {
            for (int i = 0; i < n; i++) {
                p.haveBirthday();
            }

            System.out.println(Thread.currentThread().getId() + " done.");
        }
    }

    private static void haveBirthDay(int n, Person p) {
        for (int i = 0; i < n; i++) {
            p.haveBirthday();
        }

        System.out.println(Thread.currentThread().getId() + " done.");
    }

    private int getHaveBirthDay(int n, Person p) {
        System.out.println("getHaveBirthDay start");
        for (int i = 0; i < n; i++) {
            p.haveBirthday();
        }

        return p.getAge();
    }

}
