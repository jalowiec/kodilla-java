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

        if (!sudokuBoard.getSudokuOperations().isSudokuSolved()) {

            guessingValuesSolver(sudokuBoard);
            eliminateValuesSolver(backtrack.get(backtrack.size() - 1).sudokuBoard);

            while (!backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuOperations().isSudokuSolved()) {

                guessingValuesSolver(backtrack.get(backtrack.size() - 1).sudokuBoard);
                eliminateValuesSolver(backtrack.get(backtrack.size() - 1).sudokuBoard);

                //  backtrack.get(backtrack.size()-1).sudokuBoard.getSudokuOperations().printAllValuesToEliminate();
                System.out.println(backtrack.get(backtrack.size() - 1).sudokuBoard.toString());

                String input = scannerSingleton.nextLine();
                if (!input.equals("")) {
                    {
                        System.out.println("wstrzymanie");
                    }
                }

            }
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
                        sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(row, col, valueToEliminate[0]);
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
                System.out.println("Stworzylem obiekt: ");
                System.out.println("zgadnieta wartosc:" + backtrack.get(backtrack.size() - 1).elementValue);
                System.out.println("zgadniety wspol:" + backtrack.get(backtrack.size() - 1).elementPosition[0] + " " + backtrack.get(backtrack.size() - 1).elementPosition[1]);
                System.out.println("wybor: " + backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).getValuesToEliminate());
                cloneSudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(unresolvedElementCoordinates[0] + 1, unresolvedElementCoordinates[1] + 1, unresolvedElementGuessingValue);
            } else {
                System.out.println("Error");
                int[] badElementdCoordinates = backtrack.get(backtrack.size() - 1).elementPosition;
                int wrongValue = backtrack.get(backtrack.size() - 1).elementValue;
                backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuOperations().getSudokuElement(badElementdCoordinates).deleteValueFromValuesToEliminate(wrongValue);


                if (!backtrack.get(backtrack.size() - 1).sudokuBoard.getSudokuOperations().getSudokuElement(badElementdCoordinates).getValuesToEliminate().isEmpty()) {
                    System.out.println("zgadywanie innej liczby");
                    guessingValuesSolver(sudokuBoard);
                } else {
                    System.out.println("cofka");
                    backtrack.remove(backtrack.size() - 1);
                    if (backtrack.size() > 0) {
                        guessingValuesSolver(backtrack.get(backtrack.size() - 1).sudokuBoard);
                    }
                }

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




