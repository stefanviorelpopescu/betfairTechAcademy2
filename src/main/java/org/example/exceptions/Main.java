package org.example.exceptions;

public class Main {

    public static void main(String[] args) {
        int value = runFinally();
        System.out.println(value);
    }

    private static int runFinally() {

        try {
            throw new RuntimeException("test");
//            return 0;
        } catch (Exception e) {
            return 1;
        }
        finally {
            return 2;
        }

    }
}
