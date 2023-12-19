package org.example.design_patterns;

public class Atm {

    MoneyProcessor moneyProcessor;

    public Atm() {
        moneyProcessor = new MoneyProcessor(Money.FIVE_HUNDRED);
        moneyProcessor.setNext(new MoneyProcessor(Money.TWO_HUNDRED))
                .setNext(new MoneyProcessor(Money.ONE_HUNDRED))
                .setNext(new MoneyProcessor(Money.FIFTY))
                .setNext(new MoneyProcessor(Money.TEN));
    }

    public void withdraw(int sumOfMoney) {
        System.out.println("__________");
        moneyProcessor.process(sumOfMoney);
    }
}
