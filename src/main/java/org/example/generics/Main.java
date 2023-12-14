package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        for (String s : strings) {
            System.out.println(s);
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        for (Integer number : numbers) {
            System.out.println(number);
        }

        printList(numbers);
        printList(strings);

        Number n = 5;

        print(5);
        printNumber(5);

        printList(numbers);
//        printObjectList(numbers);
    }

    public static void printList(List<?> things) {
        for (Object thing : things) {
            System.out.println(thing.toString());
        }
    }

    public static void printObjectList(List<Object> things) {
        for (Object thing : things) {
            System.out.println(thing.toString());
        }
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }

    public static void printNumber(Number n) {
        System.out.println(n.toString());
    }

    public static double sumOfList(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double sumOfGenericList(List<T> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

//    boolean isEmpty(List<String> list) {
//        return list.isEmpty();
//    }
    boolean isEmpty(List<Integer> list) {
        return list.isEmpty();
    }



}
