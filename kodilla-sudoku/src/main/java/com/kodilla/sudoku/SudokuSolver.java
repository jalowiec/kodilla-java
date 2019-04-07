package com.kodilla.sudoku;

public class SudokuSolver {
    private SudokuBoard sudokuBoard;
    public SudokuSolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void solve() {
        boolean continueMarkingProcedure = true;
        while (continueMarkingProcedure) {
            continueMarkingProcedure = false;
            int row = 1;
            for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
                int col = 1;
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                System.out.println(sudokuElement.getValuesToEliminate());
                    /*if (sudokuElement.getValuesToEliminate().size() == 1) {
                        Integer[] valueToEliminate = sudokuElement.getValuesToEliminate().stream().toArray(Integer[]::new);
                        sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(row, col, valueToEliminate[0]);
                        continueMarkingProcedure = true;
                    }*/
                    col++;
                }
                row++;
            }
        }
        sudokuBoard.toString();
    }
}




