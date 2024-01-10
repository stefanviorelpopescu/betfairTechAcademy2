package org.example.postJdk8.shapes;

public record Rectangle(double length, double width) implements Shape {
    public Rectangle {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Invalid dimensions");
        }
    }

    public double length() {
        System.out.println("Length is " + length);
        return length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
