package com.kodilla.sudoku;

import java.util.Set;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private Set<Integer>  valuesToEliminate;

    public SudokuElement() {
        this.value = EMPTY;
    }

    public int getValue() {
        return value;
    }
}
