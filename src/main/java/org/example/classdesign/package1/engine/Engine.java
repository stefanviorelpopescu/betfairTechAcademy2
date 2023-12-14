package org.example.classdesign.package1.engine;

public interface Engine {

    void start();
    void stop();
    default void makeSound() {
        System.out.println("BRRRRRR");
    }

}
