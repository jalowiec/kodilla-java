package com.kodilla.sudoku;

public class SudokuSolver {
    private SudokuBoard sudokuBoard;
    public SudokuSolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void solve() {

        eliminateValuesSolver();
        int i=2;
        while(i<4){
            guessingValuesSolver();
            eliminateValuesSolver();
            i++;
        }
    }

    private void eliminateValuesSolver(){
        boolean continueMarkingProcedure = true;
        while (continueMarkingProcedure) {
            continueMarkingProcedure = false;
            int row = 1;
            for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
                int col = 1;
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                    if (sudokuElement.getValuesToEliminate().size() == 1) {
                        Integer[] valueToEliminate = sudokuElement.getValuesToEliminate().stream().toArray(Integer[]::new);
                        sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(row, col, valueToEliminate[0]);
                        continueMarkingProcedure = true;
                    }
                    col++;
                }
                row++;
            }
        }
    }
    private void guessingValuesSolver(){
        System.out.println("uruchomienie algorytmu zgadujacego");
        try {
            System.out.println("Skopiowana tablica: ");
            sudokuBoard.deepCopy().toString();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}




