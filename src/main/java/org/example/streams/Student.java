package org.example.streams;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class Student {
    private String name;
    private int grade;
    private boolean isEmployed;
    private double salary;
    private List<Hobby> hobbies;

    public Optional<Double> getSalary() {
        if (isEmployed) {
            return Optional.empty();
        }
        return Optional.of(salary);
    }

}
