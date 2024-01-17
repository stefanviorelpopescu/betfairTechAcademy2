package org.example._7_concurrency.src.main.java.code._1_study._8_livelock;

public class TransactionThread extends Thread {
    private final BankAccount from;
    private final BankAccount to;
    private final int amount;

    public TransactionThread(String name, BankAccount from, BankAccount to, int amount) {
        super(name);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        boolean success;
        do {
            success = transferUsingLockObjects(from, to, amount);
        } while (!success); //wait for successful transfer

        if (success) {
            System.out.println("transfer " + from.getName() + " to " + to.getName() + " wih amount " + amount + " completed successfully");
        } else {
            System.out.println("transfer " + from.getName() + " to " + to.getName() + " wih amount " + amount + " not completed");
        }
    }

    private boolean transferUsingLockObjects(BankAccount from, BankAccount to, int amount) {
        boolean success = false;

        if (from.acquireLock()) {
            from.withdraw(amount); //because we pause work here, other threads have a chance to get lock on the other obj

            if (to.acquireLock()) {
                to.deposit(amount); //because we pause work here, other threads have a chance to get lock on the other obj
                to.releaseLock();
                success = true;
            }

            if (!success) from.deposit(amount); //in the case deposit was not successful, then we put the money back
            from.releaseLock();
        }

        return success;
    }

}