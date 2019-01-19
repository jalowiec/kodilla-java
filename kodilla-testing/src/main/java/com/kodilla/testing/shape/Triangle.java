package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private double a;
    private double h;

    public Triangle() {
    }

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {

        return "Shape Triangle";
    }

    @Override
    public double getField() {

        return 0.5 * a * h;
    }
}
