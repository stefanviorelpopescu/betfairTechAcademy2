package org.example.postJdk8.shapes;

public sealed interface Shape permits Circle, Square, Rectangle {
    static double getPerimeter(Shape s) throws
            IllegalArgumentException {
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle) {
            Circle c = (Circle) s;
            return 2 * c.getRadius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    static double getPerimeterPattern(Shape s) throws IllegalArgumentException {
        if (s instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle c) {
            return 2 * c.getRadius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    static double getPerimeterPatternSwitch(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c -> 2 * c.getRadius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }


}
