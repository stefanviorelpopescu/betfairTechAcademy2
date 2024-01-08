package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Throwable {
        List<Student> students = new ArrayList<>();
        students.add(new Student());

        String collect = students.parallelStream()
                .sorted(Comparator.comparingDouble(Student::getGrade).thenComparing(Student::getName).reversed())
                .filter(student -> student.getGrade() > 5)
                .map(Student::getName)
                .distinct()
                .collect(Collectors.joining(","));

        long count = students.stream()
                .map(Student::getGrade)
                .filter(grade -> grade > 5)
                .count();

        Optional<Hobby> list = students.stream()
                .flatMap(student -> student.getHobbies().stream())
                .distinct()
                .max(Comparator.comparingInt(Hobby::getCost));

        students.forEach(System.out::println);

        double minGrade = 7;

        students.forEach(student -> {
            if (student.getGrade() > minGrade) {
                System.out.println(student.getName());
//                maxGrade = student.getGrade();
            }
        });

        students.removeIf(student -> student.getGrade() < 4);


        new Thread(() -> System.out.println("test")).start();
        TreeSet<Student> treeSet = new TreeSet<>(Comparator.comparingDouble(Student::getGrade));

        playTheLottery(() -> List.of(1, 5, 24, 32, 41, 45));

        Student student = new Student();

        Optional<Double> optionalSalary = student.getSalary();
        if (optionalSalary.isEmpty()) {
            throw new RuntimeException("Salary is empty");
        }
        System.out.println(optionalSalary.get());

        Double salary = student.getSalary()
                .orElseThrow(() -> new RuntimeException("Salary is empty"));
        System.out.println(salary);

        Map<Integer, List<Student>> studentsByGrade = new HashMap<>();
        students.forEach(student1 -> studentsByGrade.computeIfAbsent(student1.getGrade(), integer -> new ArrayList<>()).add(student1));

        Map<Integer, List<Student>> studentsByGrade1 = students.stream()
                .filter(Student::isEmployed)
                .collect(Collectors.groupingBy(Student::getGrade));

        Map<Integer, List<String>> studentsByGrade2 = students.stream()
                .filter(Student::isEmployed)
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));
    }

    public static void playTheLottery(Lottery lottery) {

        System.out.println(lottery.drawNumbers());

    }
}
