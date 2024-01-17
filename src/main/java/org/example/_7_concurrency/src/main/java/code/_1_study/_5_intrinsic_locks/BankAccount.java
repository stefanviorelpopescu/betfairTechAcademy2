package org.example._7_concurrency.src.main.java.code._1_study._5_intrinsic_locks;

public class BankAccount {
    private final String name;
    private int debit;

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
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