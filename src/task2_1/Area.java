package task2_1;

import static java.lang.Math.PI;

public class Area extends Shape{

    @Override
    public double rectangleArea(double length, double breadth) {
        // A = l*b;
        return length*breadth;

    }

    @Override
    public double squareArea(double side) {
        // A = s^2;
        return Math.pow(side, 2);
    }

    @Override
    public double circleArea(double radius) {
        // A = π r^2
        final double pi = PI;
        return pi * Math.pow(radius, 2);
    }
}
