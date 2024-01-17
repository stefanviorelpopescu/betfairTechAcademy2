package org.example._7_concurrency.src.main.java.code._1_study;

import org.example._7_concurrency.src.main.java.code._1_study.threads.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        MyRunnable runnable = new MyRunnable();
//        new Thread(runnable).start();
        MyThread myThread = new MyThread();
        myThread.setPriority(5);
        myThread.start();

//        Thread.sleep(1000);

//        try (ScheduledExecutorService ses = Executors.newScheduledThreadPool(1)) {
//            ses.schedule(runnable, 5, TimeUnit.SECONDS);
//        }

//        myThread.join();

//        System.out.println(new Date() + " Main start");
//
//
//        Counter counter = new AtomicCounter();
//
//        List<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 1_000; i++) {
//            threads.add(new Thread(new MyRunnable(counter)));
//        }
//        threads.forEach(Thread::start);
//        threads.forEach(Main::joinThread);
//
//        System.out.println(counter.getCount());
//
//        System.out.println(new Date() + " Main is over");

        List<String> names = new ArrayList<>();
        List<String> refList = names;
        System.out.println(names == refList);

        names.add("test");
        System.out.println(names);
        System.out.println(refList);
        System.out.println(names == refList);

        String name = "Ion";
        String ref = name;
        System.out.println(name == ref);

        name += "el";
        System.out.println(name);
        System.out.println(ref);
        System.out.println(name == ref);

        String ion = "Ion";
        String ion2 = "Ion";
        System.out.println(ion == ion2);

        List<String> synchronizedList = Collections.synchronizedList(names);

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 1000_000; i++) {
            s += "a";
        }
//        System.out.println(s);
        System.out.println("Duration:" + (System.currentTimeMillis() - start));

        Integer number1 = 1234;
        Integer number2 = 1234;
        System.out.println(number1 == number2);

    }

    private static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}