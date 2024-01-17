package org.example._7_concurrency.src.main.java.code._1_study.threads;

public class MyRunnable implements Runnable {

    private final Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter.increment();
        }
    }
}
