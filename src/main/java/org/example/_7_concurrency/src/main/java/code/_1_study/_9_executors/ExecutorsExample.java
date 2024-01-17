package org.example._7_concurrency.src.main.java.code._1_study._9_executors;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS; //the time unit for the {@code keepAliveTime} argument
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        ExecutorService executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= 15; i++) {
            executor.execute(new Task("task" + i));
        }
    }
}
