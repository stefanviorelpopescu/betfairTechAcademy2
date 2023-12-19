package org.example.design_patterns;

public class MoneyProcessor {
    private final Money money;
    private MoneyProcessor next;
    int stock = 10;

    public MoneyProcessor(Money money) {
        this.money = money;
    }

    public MoneyProcessor setNext(MoneyProcessor nextProcessor) {
        this.next = nextProcessor;
        return  nextProcessor;
    }

    public void process(int sumOfMoney) {

        int value = money.getValue();

        int count = sumOfMoney / value;

        if (count == 0) {
            next.process(sumOfMoney);
            return;
        }

        if (count > stock) {
            count = stock;
        }
        stock -= count;
        if (count > 0) {
            System.out.println(count + "\tx\t" + value);
        }

        int remainingSum = sumOfMoney - count * value;
        if (remainingSum > 0) {
            if (next != null) {
                next.process(remainingSum);
            } else {
                throw new RuntimeException("Caanot finish processing");
            }
        }

    }
}
