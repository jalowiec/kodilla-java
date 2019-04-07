package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private Set<Integer> valuesToEliminate = new HashSet<>();

    public SudokuElement() {
        this.value = EMPTY;
        setAllValuesToEliminate();

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Integer> getValuesToEliminate() {
        return valuesToEliminate;
    }

    public void setValuesToEliminate(Set<Integer> valuesToEliminate) {
        this.valuesToEliminate = valuesToEliminate;
    }

    public void setAllValuesToEliminate() {
        for (int i = 1; i < 10; i++) {
            valuesToEliminate.add(i);
        }
    }



}
