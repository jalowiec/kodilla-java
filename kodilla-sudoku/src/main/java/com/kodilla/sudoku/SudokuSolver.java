package com.kodilla.sudoku;

import java.util.*;

public class SudokuSolver {
    private SudokuBoard sudokuBoard;
    private List<Set<Integer>> listOfUnusedValuesForRows = new ArrayList<>();
    private List<Set<Integer>> listOfUnusedValuesForColumns = new ArrayList<>();
    private List<Set<Integer>> listOfUnusedValuesForSection = new ArrayList<>();


    public SudokuSolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void solve() {
        for (int i = 0; i < sudokuBoard.getSudokuRowList().size(); i++) {
            SudokuRow sudokuRow = sudokuBoard.getSudokuRowList().get(i);
            listOfUnusedValuesForRows.add(setUsedValueForRow(sudokuRow));
            eliminateUsedValueForRow(sudokuRow, i);
        }
    }

    private Set<Integer> setUsedValueForRow(SudokuRow sudokuRow) {
        Set<Integer> usedValuesForRow = new HashSet<>();
        for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
            int valueToAdd = sudokuElement.getValue();
            if (valueToAdd != -1) {
                usedValuesForRow.add(valueToAdd);
            }
        }
        return usedValuesForRow;
    }

    private void eliminateUsedValueForRow(SudokuRow sudokuRow, int sudokuRowIndex) {
        for (int i = 0; i < sudokuRow.getSudokuElementList().size(); i++) {
            sudokuRow.getSudokuElementList().get(i).getValuesToEliminate().removeAll(listOfUnusedValuesForRows.get(sudokuRowIndex));
        }
    }


}
