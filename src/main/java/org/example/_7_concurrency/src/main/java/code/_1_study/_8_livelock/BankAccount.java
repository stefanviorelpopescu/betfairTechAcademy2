package org.example._7_concurrency.src.main.java.code._1_study._8_livelock;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class BankAccount {
    private final String name;
    private int debit;
    private final Lock lock = new ReentrantLock(true);

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public boolean acquireLock() {
        //lock.lock(); return true; //can result in deadlock
        return lock.tryLock(); //can result in livelock
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