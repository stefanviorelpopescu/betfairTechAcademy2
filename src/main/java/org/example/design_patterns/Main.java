package org.example.design_patterns;

public class Main {
    public static void main(String[] args) {
        Student student = Student.builder()
                .age(32)
                .name("Ion")
                .build();

        System.out.println("Ion");
        String s = "Ion";
        String s2 = "Ion";

        Atm atm = new Atm();

        atm.withdraw(480);
        atm.withdraw(5000);
        atm.withdraw(1600);
        atm.withdraw(450);
//        atm.withdraw(7000);
    }
}
