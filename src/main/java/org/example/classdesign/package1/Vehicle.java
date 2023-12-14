package org.example.classdesign.package1;

import org.example.classdesign.package1.engine.Engine;
import org.example.classdesign.package2.CarPark;

public class Vehicle {

    private Engine engine;

    private CarPark carPark;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public static final int WHEEL_NO = 4;

    public int fuelLeft;
    int wheels;

    public void displayFuel() {
        System.out.println(this.fuelLeft);
    }

    public int getWheels() {
        return wheels;
    }

    public void turnOn() {
        engine.start();
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }
}
