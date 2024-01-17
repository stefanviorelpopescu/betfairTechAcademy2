package org.example._7_concurrency.src.main.java.code._1_study.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter{

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void increment() {
       counter.incrementAndGet();
    }

    @Override
    public int getCount() {
        return counter.get();
    }
}
