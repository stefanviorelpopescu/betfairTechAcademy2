package org.example.classdesign.package2;

import org.example.classdesign.package1.Vehicle;
import org.example.classdesign.package1.engine.ElectricEngine;


public class CarPark {


    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(new ElectricEngine());

        System.out.println(vehicle.fuelLeft);
//        System.out.println(vehicle.wheels);
    }

}
