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

        while (!sudokuBoard.getSudokuOperations().isSudokuSolved(sudokuBoard)) {
            guessingValuesSolver(sudokuBoard);
            //System.out.println("po zgadnieciu: " + sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).getValuesToEliminate());
            System.out.println("po zgadnieciu: " +  sudokuBoard.hashCode());
            eliminateValuesSolver(sudokuBoard);
            System.out.println(sudokuBoard.toString());

            String input = scannerSingleton.nextLine();
            if (!input.equals("")) {
                {
                    System.out.println("wstrzymanie");
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
                    System.out.println("rozmiar: " + sudokuElement.getValuesToEliminate().size());
                    if (sudokuElement.getValuesToEliminate().size() == 1) {
                        scannerSingleton.nextLine();
                        Integer[] valueToEliminate = sudokuElement.getValuesToEliminate().stream().toArray(Integer[]::new);
                        sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(row, col, valueToEliminate[0]);
                        continueMarkingProcedure = true;
                    }
                    col++;
                }
                row++;
            }
        }
        System.out.println("SOLVEe");
    }

    private void guessingValuesSolver(SudokuBoard sudokuBoard) {
        try {


            int[] unresolvedElementCoordinates = getCoordinatesUnresolvedElement(sudokuBoard);
            int unresolvedElementGuessingValue = getElementValue(unresolvedElementCoordinates[0], unresolvedElementCoordinates[1], sudokuBoard);
            if (unresolvedElementGuessingValue != -1) {
                SudokuBoard cloneSudokuBoard = sudokuBoard.deepCopy();
                backtrack.add(new SudokuGameState(cloneSudokuBoard, unresolvedElementCoordinates, unresolvedElementGuessingValue));
                System.out.println(backtrack.get(backtrack.size()-1).sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).getValuesToEliminate());
                System.out.println("---" + backtrack.size());
                //printBackTrack();

                sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(unresolvedElementCoordinates[0] + 1, unresolvedElementCoordinates[1] + 1, unresolvedElementGuessingValue);
            } else {
                System.out.println("Error");
                int eliminateValue = backtrack.get(backtrack.size()-1).elementValue;
                int[] positionToEliminate = backtrack.get(backtrack.size()-1).elementPosition;
                System.out.println(eliminateValue);
                System.out.println(positionToEliminate[0] + " " + positionToEliminate[1]);
                backtrack.get(backtrack.size()-1).sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).deleteValueFromValuesToEliminate(eliminateValue);

                System.out.println("SUDOKUBOARD: " + sudokuBoard.hashCode());
                System.out.println("BACKTRACKBOARD: " + backtrack.get(backtrack.size()-1).hashCode());
                System.out.println(sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).getValuesToEliminate());
                System.out.println("--");
                sudokuBoard = backtrack.get(backtrack.size()-1).sudokuBoard;
                System.out.println("COPYUBOARD: " + sudokuBoard.hashCode());
                System.out.println(sudokuBoard.getSudokuRowList().get(positionToEliminate[0]).getSudokuElementList().get(positionToEliminate[1]).getValuesToEliminate());
                solve(sudokuBoard);

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

    private void printBackTrack(){

        for (SudokuGameState sudokuGameState : backtrack){

            System.out.println(sudokuGameState.sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).getValuesToEliminate());

        }

    }


}




