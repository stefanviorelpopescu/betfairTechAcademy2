package org.example.classdesign.package2;

import org.example.classdesign.package1.Vehicle;
import org.example.classdesign.package1.engine.Engine;

public class ElectricVehicle extends Vehicle {

    public ElectricVehicle(Engine engine) {
        super(engine);
    }

    public void changeWheels() {
        System.out.println(getWheels());
    }
}
