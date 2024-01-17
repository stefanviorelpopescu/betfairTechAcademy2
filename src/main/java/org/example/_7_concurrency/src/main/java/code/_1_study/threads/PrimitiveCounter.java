package org.example._7_concurrency.src.main.java.code._1_study.threads;

public class PrimitiveCounter implements Counter{
    private int count = 0;
    private int count2 = 0;

    private final Object lock = new Object();
    private final Object lock2 = new Object();

    @Override
    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    public void increment2() {
        synchronized (lock2) {
            count2++;
        }
    }
}
