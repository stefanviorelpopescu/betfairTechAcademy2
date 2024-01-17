package org.example._7_concurrency.src.main.java.code._1_study.callable;

import lombok.SneakyThrows;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CallableHandler implements Runnable{
    private final Future<Integer> result;
    private final ScheduledExecutorService scheduledExecutorService;

    public CallableHandler(Future<Integer> result, ScheduledExecutorService scheduledExecutorService) {
        this.result = result;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Checking result");
        if (result.isDone()) {
            System.out.println(result.get());
        } else {
            scheduledExecutorService.schedule(new CallableHandler(result, scheduledExecutorService), 1, TimeUnit.SECONDS);
        }
    }
}
