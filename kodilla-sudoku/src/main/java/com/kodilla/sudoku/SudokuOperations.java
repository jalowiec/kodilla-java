package com.kodilla.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuOperations {


    private Map<Integer, Integer[]> pointersForSudokuSection = new HashMap<>();



    public void insertValueIntoSudokuTable(SudokuBoard sudokuBoard, int userRowNumber, int userColNumber, int newValue) {


            int rowNumber = userRowNumber - 1;
            int colNumber = userColNumber - 1;

            SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList().get(colNumber);
            int oldValue = sudokuElement.getValue();
            sudokuElement.setValue(newValue);

            if (oldValue == -1 && newValue != -1) {
                sudokuElement.getValuesToEliminate().clear();
                removeValueFromValuesToEliminateFromRow(sudokuBoard, rowNumber, newValue);
                removeValueFromValuesToEliminateFromColumn(sudokuBoard, colNumber, newValue);
                removeValueFromValuesToEliminateFromSection(sudokuBoard, rowNumber, colNumber, newValue);
            } else if (oldValue != -1 && newValue == -1) {
                setValuesToEliminate(sudokuBoard, sudokuElement);
                addValueToValuesToEliminateToRow(sudokuBoard, rowNumber, oldValue);
                addValueToValuesToEliminateToColumn(sudokuBoard, colNumber, oldValue);
                addValueToValuesToEliminateToSection(sudokuBoard, rowNumber, colNumber, oldValue);
            } else if (oldValue != -1 && newValue != -1) {
                removeValueFromValuesToEliminateFromRow(sudokuBoard, rowNumber, newValue);
                removeValueFromValuesToEliminateFromColumn(sudokuBoard, colNumber, newValue);
                removeValueFromValuesToEliminateFromSection(sudokuBoard, rowNumber, colNumber, newValue);
                addValueToValuesToEliminateToRow(sudokuBoard, rowNumber, oldValue);
                addValueToValuesToEliminateToColumn(sudokuBoard, colNumber, oldValue);
                addValueToValuesToEliminateToSection(sudokuBoard, rowNumber, colNumber, oldValue);
            }


    }

    private void removeValueFromValuesToEliminateFromRow(SudokuBoard sudokuBoard, int rowNumber, int valueToEliminate) {
        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()) {
            sudokuElement.getValuesToEliminate().remove(valueToEliminate);
        }
    }

    private void addValueToValuesToEliminateToRow(SudokuBoard sudokuBoard, int rowNumber, int valueToAdd) {
        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()) {
            if (!sudokuElement.getValuesToEliminate().isEmpty()) {
                sudokuElement.getValuesToEliminate().add(valueToAdd);
            }
        }
    }

    private void removeValueFromValuesToEliminateFromColumn(SudokuBoard sudokuBoard, int colNumberInList, int valueToEliminate) {
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().remove(valueToEliminate);
        }
    }

    private void addValueToValuesToEliminateToColumn(SudokuBoard sudokuBoard, int colNumberInList, int valueToAdd) {
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            if (!sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().isEmpty()) {
                sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().add(valueToAdd);
            }
        }
    }


    private void removeValueFromValuesToEliminateFromSection(SudokuBoard sudokuBoard, int rowNumber, int colNumber, int valueToEliminate) {

        Integer[] rowNumberIndexTable = pointersForSudokuSection.get(rowNumber % 3);
        Integer[] colNumberIndexTable = pointersForSudokuSection.get(colNumber % 3);


        for (int i = 0; i < rowNumberIndexTable.length; i++) {
            for (int j = 0; j < colNumberIndexTable.length; j++) {

                sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().remove(valueToEliminate);
            }
        }
    }

    private void addValueToValuesToEliminateToSection(SudokuBoard sudokuBoard, int rowNumber, int colNumber, int valueToAdd) {

        Integer[] rowNumberIndexTable = pointersForSudokuSection.get(rowNumber % 3);
        Integer[] colNumberIndexTable = pointersForSudokuSection.get(colNumber % 3);


        for (int i = 0; i < rowNumberIndexTable.length; i++) {
            for (int j = 0; j < colNumberIndexTable.length; j++) {
                if (!sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().isEmpty()) {
                    sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().add(valueToAdd);
                }
            }
        }
    }

    private void setValuesToEliminate(SudokuBoard sudokuBoard, SudokuElement sudokuElementToChange) {
        sudokuElementToChange.setAllValuesToEliminate();
        Set<Integer> usedValues = new HashSet<>();
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                usedValues.add(sudokuElement.getValue());
            }
        }
        sudokuElementToChange.getValuesToEliminate().removeAll(usedValues);

    }

    public void fillPointersForSudokuSection() {
        pointersForSudokuSection.put(0, new Integer[]{1, 2});
        pointersForSudokuSection.put(1, new Integer[]{-1, 1});
        pointersForSudokuSection.put(2, new Integer[]{-2, -1});

    }


    public boolean isInputNumberValid(SudokuBoard sudokuBoard, int userRowNumber, int userColNumber, int value) {
        int rowNumber = userRowNumber - 1;
        int colNumber = userColNumber - 1;

        Integer[] rowNumberIndexTable = pointersForSudokuSection.get(rowNumber % 3);
        Integer[] colNumberIndexTable = pointersForSudokuSection.get(colNumber % 3);


        for (SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()) {
            if (value != -1 && sudokuElement.getValue() == value) {
                return false;
            }
        }
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            if (value != -1 && sudokuRow.getSudokuElementList().get(colNumber).getValue() == value) {
                return false;
            }
        }

        for (int i = 0; i < rowNumberIndexTable.length; i++) {
            for (int j = 0; j < colNumberIndexTable.length; j++) {
                if (value != -1 && sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValue() == value) {
                    return false;
                }
            }
        }


        return true;
    }

    public boolean isSudokuSolved(SudokuBoard sudokuBoard) {
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                if (sudokuElement.getValue() == -1) {
                    return false;
                }
            }
        }

        return true;
    }



}
