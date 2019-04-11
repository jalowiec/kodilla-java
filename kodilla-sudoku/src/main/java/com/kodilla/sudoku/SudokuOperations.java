package com.kodilla.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuOperations {

    private SudokuBoard sudokuBoard;
    private Map<Integer, Integer[]> pointersForSudokuSection = new HashMap<>();


    public SudokuOperations(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        fillPointersForSudokuSection();
    }

    public void insertValueIntoSudokuTable(int userRowNumber, int userColNumber, int newValue) {
        int rowNumber = userRowNumber-1;
        int colNumber = userColNumber-1;

        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList().get(colNumber);
        int oldValue = sudokuElement.getValue();

        sudokuElement.setValue(newValue);

        if(oldValue == -1 && newValue != -1){
            sudokuElement.getValuesToEliminate().clear();
            removeValueFromValuesToEliminateFromRow(rowNumber, newValue);
            removeValueFromValuesToEliminateFromColumn(colNumber, newValue);
            removeValueFromValuesToEliminateFromSection(rowNumber, colNumber, newValue);
        } else if (oldValue != -1 && newValue == -1){
            setValuesToEliminate(sudokuElement);
            addValueToValuesToEliminateToRow(rowNumber, oldValue);
            addValueToValuesToEliminateToColumn(colNumber, oldValue);
            addValueToValuesToEliminateToSection(rowNumber, colNumber, oldValue);
        } else if (oldValue != -1 && newValue != -1){
            removeValueFromValuesToEliminateFromRow(rowNumber, newValue);
            removeValueFromValuesToEliminateFromColumn(colNumber, newValue);
            removeValueFromValuesToEliminateFromSection(rowNumber, colNumber, newValue);
            addValueToValuesToEliminateToRow(rowNumber, oldValue);
            addValueToValuesToEliminateToColumn(colNumber, oldValue);
            addValueToValuesToEliminateToSection(rowNumber, colNumber, oldValue);
        }
    }

    private void removeValueFromValuesToEliminateFromRow(int rowNumber, int valueToEliminate){
        for(SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()){
            sudokuElement.getValuesToEliminate().remove(valueToEliminate);
          }
    }

    private void addValueToValuesToEliminateToRow(int rowNumber, int valueToAdd){
        for(SudokuElement sudokuElement : sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList()){
            if(!sudokuElement.getValuesToEliminate().isEmpty()) {
                sudokuElement.getValuesToEliminate().add(valueToAdd);
            }
        }
    }

    private void removeValueFromValuesToEliminateFromColumn(int colNumberInList, int valueToEliminate){
        for(SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()){
            sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().remove(valueToEliminate);
         }
    }

    private void addValueToValuesToEliminateToColumn(int colNumberInList, int valueToAdd){
        for(SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()){
            if(!sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().isEmpty()) {
                sudokuRow.getSudokuElementList().get(colNumberInList).getValuesToEliminate().add(valueToAdd);
            }
        }
    }


    private void removeValueFromValuesToEliminateFromSection(int rowNumber, int colNumber, int valueToEliminate){

        Integer[] rowNumberIndexTable = pointersForSudokuSection.get(rowNumber % 3);
        Integer[] colNumberIndexTable = pointersForSudokuSection.get(colNumber % 3);


        for (int i = 0; i < rowNumberIndexTable.length; i++) {
            for (int j = 0; j < colNumberIndexTable.length; j++) {

                sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().remove(valueToEliminate);
            }
        }
    }

    private void addValueToValuesToEliminateToSection(int rowNumber, int colNumber, int valueToAdd){

        Integer[] rowNumberIndexTable = pointersForSudokuSection.get(rowNumber % 3);
        Integer[] colNumberIndexTable = pointersForSudokuSection.get(colNumber % 3);


        for (int i = 0; i < rowNumberIndexTable.length; i++) {
            for (int j = 0; j < colNumberIndexTable.length; j++) {
                if(!sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().isEmpty()) {
                    sudokuBoard.getSudokuRowList().get(rowNumber + rowNumberIndexTable[i]).getSudokuElementList().get(colNumber + colNumberIndexTable[j]).getValuesToEliminate().add(valueToAdd);
                }
            }
        }
    }

    private void setValuesToEliminate(SudokuElement sudokuElementToChange){
        sudokuElementToChange.setAllValuesToEliminate();
        Set<Integer> usedValues = new HashSet<>();
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                usedValues.add(sudokuElement.getValue());
            }
        }
        sudokuElementToChange.getValuesToEliminate().removeAll(usedValues);

    }

    private void fillPointersForSudokuSection(){
        pointersForSudokuSection.put(0, new Integer[]{1, 2});
        pointersForSudokuSection.put(1, new Integer[]{-1, 1});
        pointersForSudokuSection.put(2, new Integer[]{-2, -1});

    }

    public void printAllValuesToEliminate(){
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                System.out.println(sudokuElement.getValuesToEliminate());
            }
        }
    }

    public boolean isInputNumberValid(int userRowNumber, int userColNumber, int value){
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

    public boolean isSudokuSolved(){
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()){
            for(SudokuElement sudokuElement : sudokuRow.getSudokuElementList()){
                if(!sudokuElement.getValuesToEliminate().isEmpty()){
                    return false;
                }
            }
        }

        return true;
    }



}
