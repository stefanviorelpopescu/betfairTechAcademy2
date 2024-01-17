package org.example._7_concurrency.src.main.java.code._1_study._6_lock_objects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String name;
    private int debit;
    private final Lock lock = new ReentrantLock(true);

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public boolean acquireLock() {
        lock.lock(); //can result in deadlock
        return true;
        //return lock.tryLock(); //can result in livelock
    }

    public void releaseLock() {
        lock.unlock();
    }

    void withdraw(int amount) {
        simulateLongDatabaseCall();
        this.debit -= amount;
    }

    void deposit(int amount) {
        simulateLongDatabaseCall();
        this.debit += amount;
    }

    private void simulateLongDatabaseCall() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", debit=" + debit +
                '}';
    }
}