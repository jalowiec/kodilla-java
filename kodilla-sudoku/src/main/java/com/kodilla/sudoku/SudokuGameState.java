package com.kodilla.sudoku;

public class SudokuGameState {
    SudokuBoard sudokuBoard;
    int[] elementPosition;
    int elementValue;

    public SudokuGameState(SudokuBoard sudokuBoard, int[] elementPosition, int elementValue) {
        this.sudokuBoard = sudokuBoard;
        this.elementPosition = elementPosition;
        this.elementValue = elementValue;
    }
}
