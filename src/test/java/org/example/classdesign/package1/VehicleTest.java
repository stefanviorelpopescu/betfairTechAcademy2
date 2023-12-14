package org.example.classdesign.package1;


import org.example.classdesign.package1.engine.DieselEngine;
import org.junit.jupiter.api.BeforeEach;

class VehicleTest {
    Vehicle vehicle = new Vehicle(new DieselEngine());

    @BeforeEach
    public void setUp() {
        vehicle.wheels = 7;
    }
}