package org.example._7_concurrency.src.main.java.code._1_study.threads;

import java.util.Date;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(new Date() + " This is a thread");
    }
}
