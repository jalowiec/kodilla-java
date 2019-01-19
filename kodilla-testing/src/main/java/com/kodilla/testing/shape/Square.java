package com.kodilla.testing.shape;

public class Square implements Shape {

    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return "Shape Square";
    }

    @Override
    public double getField() {
        return a* a;
    }
}
