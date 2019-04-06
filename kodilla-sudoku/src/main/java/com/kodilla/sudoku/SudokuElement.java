package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private Set<Integer> valuesToEliminate = new HashSet<>();

    public SudokuElement(int sudokuTableSize) {
        this.value = EMPTY;
        fillAllValuesToEliminate(sudokuTableSize);

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


    public void fillAllValuesToEliminate(int sudokuTableSize) {
        for (int i = 1; i <= sudokuTableSize; i++) {
            valuesToEliminate.add(i);
        }
    }



}
