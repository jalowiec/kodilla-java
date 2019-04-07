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
            removeValuefromValuesToEliminateFromRow(rowNumber, value);
            removeValuefromValuesToEliminateFromColumn(colNumber, value);
        } else {
            sudokuElement.fillAllValuesToEliminate(sudokuBoard.getSudokuRowList().size());
        }

    }
    private void removeValuefromValuesToEliminateFromRow(int rowNumber, int valueToEliminate){
        for(SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()){
            sudokuElement.getValuesToEliminate().remove(valueToEliminate);
          }
    }

    private void removeValuefromValuesToEliminateFromColumn(int colNumber, int valueToEliminate){
        for(SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()){
            sudokuRow.getSudokuElementList().get(colNumber).getValuesToEliminate().remove(valueToEliminate);
         }
    }

}
