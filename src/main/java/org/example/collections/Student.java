package org.example.collections;

import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode
public class Student {

    public Student(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    String name;
    int age;
    boolean married;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && married == student.married && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, married);
//    }
}
