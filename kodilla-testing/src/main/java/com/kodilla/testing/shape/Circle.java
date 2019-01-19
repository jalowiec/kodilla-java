package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {

        return "Shape Circle";
    }

    @Override
    public double getField() {
        return Math.PI * r * r;
    }
}
