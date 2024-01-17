package org.example._7_concurrency.src.main.java.code._1_study.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private final int waitTime;

    public MyCallable(int waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(waitTime);
        return 1;
    }
}
