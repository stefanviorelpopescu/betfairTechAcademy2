package org.example._7_concurrency.src.main.java.code._1_study.callable;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new MyCallable(5000);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(callable);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new CallableHandler(result, scheduledExecutorService), 1, TimeUnit.SECONDS);

//        Integer i = result.get();
//        System.out.println(i);

        System.out.println("Main is done");
    }
}
