package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapesList = new ArrayList<>();


    public void addFigure(Shape shape){
        if(shape != null) {
            shapesList.add(shape);
        }
    }

    public boolean removeFigure(Shape shape){
        if(shapesList.contains(shape)){
            shapesList.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        if(n >= 0 && n < shapesList.size()) {
            return shapesList.get(n);
        }
        else return null;
    }


    public List<Shape> showFigures(){
        return shapesList;
    }

}
