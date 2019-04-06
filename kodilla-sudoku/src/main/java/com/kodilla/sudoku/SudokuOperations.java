package com.kodilla.sudoku;

public class SudokuOperations {

    SudokuBoard sudokuBoard;

    public SudokuOperations(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void insertValueIntoSudokuTable(int rowNumber, int colNumber, int value) {

        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList().get(colNumber);
        sudokuElement.setValue(value);

        if (value != -1) {
            sudokuElement.getValuesToEliminate().clear();
        } else {
            sudokuElement.fillAllValuesToEliminate(sudokuBoard.getSudokuRowList().size());
        }

    }

}
