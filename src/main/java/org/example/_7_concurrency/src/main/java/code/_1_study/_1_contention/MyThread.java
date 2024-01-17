package org.example._7_concurrency.src.main.java.code._1_study._1_contention;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1_000_000; i++) {
            ContentionExample.v++;
        }
    }
}