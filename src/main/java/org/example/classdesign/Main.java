package org.example.classdesign;

import org.example.classdesign.package1.Vehicle;
import org.example.classdesign.package1.engine.DieselEngine;
import org.example.classdesign.package1.engine.ElectricEngine;
import org.example.classdesign.package1.engine.WaterEngine;
import org.example.classdesign.package2.CarPark;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = new LinkedList<>();
        displayNames(names);

        Map<String, String> nameMap = new HashMap<>();

        try (FileReader fileReader = new FileReader("test")) {
            int read = fileReader.read();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Vehicle vehicle = new Vehicle(new DieselEngine());
        Vehicle vehicle2 = new Vehicle(new ElectricEngine());
        vehicle.turnOn();

        vehicle.setEngine(new WaterEngine());
        vehicle.setCarPark(new CarPark());

        int i = displayNames(names);
        TreeSet<Integer> numbers = new TreeSet<>();
        TreeSet<Vehicle> vehicles = new TreeSet<>(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.fuelLeft - o2.fuelLeft;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                displayNames(List.of("test"));
            }
        });

    }

    public static int displayNames(List<String> names) {

        if (names.isEmpty()) {
            System.out.println("No names");
        }
        return names.size();
    }

}
