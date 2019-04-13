package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static com.kodilla.sudoku.SudokuElement.EMPTY;

public class SudokuSolver {

    List<SudokuGameState> backtrack = new ArrayList<>();
    Scanner scannerSingleton = ScannerSingleton.getInstance();


    public void solve(SudokuBoard sudokuBoard) {


        eliminateValuesSolver(sudokuBoard);
        if (sudokuBoard.getSudokuOperations().isSudokuSolved(sudokuBoard)) {
            System.out.println(sudokuBoard.toString());
            System.exit(0);
        }

        while (!sudokuBoard.getSudokuOperations().isSudokuSolved(sudokuBoard)) {
            guessingValuesSolver(sudokuBoard);
            eliminateValuesSolver(sudokuBoard);

        }

    }

    private void eliminateValuesSolver(SudokuBoard sudokuBoard) {
        boolean continueMarkingProcedure = true;
        while (continueMarkingProcedure) {
            continueMarkingProcedure = false;
            int row = 1;
            for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
                int col = 1;
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                    if (sudokuElement.getValuesToEliminate().size() == 1) {
                        Integer[] valueToEliminate = sudokuElement.getValuesToEliminate().stream().toArray(Integer[]::new);
                        sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(sudokuBoard, row, col, valueToEliminate[0]);
                        continueMarkingProcedure = true;
                    }
                    col++;
                }
                row++;
            }
        }
    }

    private void guessingValuesSolver(SudokuBoard sudokuBoard) {
        try {


            int[] unresolvedElementCoordinates = getCoordinatesUnresolvedElement(sudokuBoard);
            int unresolvedElementGuessingValue = getElementValue(unresolvedElementCoordinates[0], unresolvedElementCoordinates[1], sudokuBoard);
            if (unresolvedElementGuessingValue != -1) {
                SudokuBoard cloneSudokuBoard = sudokuBoard.deepCopy();
                backtrack.add(new SudokuGameState(cloneSudokuBoard, unresolvedElementCoordinates, unresolvedElementGuessingValue));
                sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(sudokuBoard, unresolvedElementCoordinates[0] + 1, unresolvedElementCoordinates[1] + 1, unresolvedElementGuessingValue);

            } else {
                int eliminateValue = backtrack.get(backtrack.size() - 1).elementValue;
                int[] positionToEliminate = backtrack.get(backtrack.size() - 1).elementPosition;
                backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).deleteValueFromValuesToEliminate(eliminateValue);

                if (backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).getValuesToEliminate().isEmpty()) {

                    backtrack.remove(backtrack.size() - 1);
                    eliminateValue = backtrack.get(backtrack.size() - 1).elementValue;
                    positionToEliminate = backtrack.get(backtrack.size() - 1).elementPosition;
                    backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).deleteValueFromValuesToEliminate(eliminateValue);

                }
                solve(backtrack.get(backtrack.size() - 1).sudokuBoard);
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private int[] getCoordinatesUnresolvedElement(SudokuBoard sudokuBoard) {
        int[] elementCoordinates = new int[2];
        for (int i = 0; i < sudokuBoard.getSudokuRowList().size(); i++) {
            for (int j = 0; j < sudokuBoard.getSudokuRowList().size(); j++) {
                if (sudokuBoard.getSudokuRowList().get(i).getSudokuElementList().get(j).getValue() == EMPTY) {
                    elementCoordinates[0] = i;
                    elementCoordinates[1] = j;
                    return elementCoordinates;
                }
            }
        }
        return elementCoordinates;
    }

    private int getElementValue(int elementRow, int elementCol, SudokuBoard sudokuBoard) {
        Set<Integer> valuesToEliminate = sudokuBoard.getSudokuRowList().get(elementRow).getSudokuElementList().get(elementCol).getValuesToEliminate();

        for (int i = 1; i < 10; i++) {
            if (valuesToEliminate.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}




