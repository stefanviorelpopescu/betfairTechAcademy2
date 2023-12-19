package org.example.design_patterns;

public enum Money {
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ;

    final int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
