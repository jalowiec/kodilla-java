package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard implements Cloneable{

    private List<SudokuRow> sudokuRowList = new ArrayList<>();
    private SudokuOperations sudokuOperations;

    public SudokuBoard(List<SudokuRow> sudokuRowList){
        this.sudokuRowList = sudokuRowList;
        sudokuOperations = new SudokuOperations(this);
    }

    public List<SudokuRow> getSudokuRowList() {
        return sudokuRowList;
    }

    public SudokuOperations getSudokuOperations() {
        return sudokuOperations;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getHorizontalLine(sudokuRowList.size()));
        for(int i=0; i<sudokuRowList.size(); i++){
            stringBuilder.append("| ");
            for(int j=0; j<sudokuRowList.size(); j++) {
                if(sudokuRowList.get(i).getSudokuElementList().get(j).getValue()==-1) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(sudokuRowList.get(i).getSudokuElementList().get(j).getValue());
                }
                stringBuilder.append(" | ");
            }
            stringBuilder.append("\n");
            stringBuilder.append(getHorizontalLine(sudokuRowList.size()));
        }
        return stringBuilder.toString();
    }

    private String getHorizontalLine(int lineLength){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<lineLength; i++){
            stringBuilder.append(" ___");
        }
       stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException{
        SudokuBoard cloneBoard = (SudokuBoard) this.clone();
        initCloneSudokuBoard(cloneBoard);

        return cloneBoard;
    }

    private void initCloneSudokuBoard(SudokuBoard cloneSudokuBoard){

        new SudokuOperations(this);
        List<SudokuRow> cloneSudokuRowList = new ArrayList<>();

        for (int i = 0; i < this.sudokuRowList.size(); i++) {
            SudokuRow cloneSudokuRow = new SudokuRow();
            for (int j = 0; j < this.sudokuRowList.size(); j++) {
                SudokuElement cloneSudokuElement = new SudokuElement();
                cloneSudokuElement.getValuesToEliminate().addAll(this.sudokuRowList.get(i).getSudokuElementList().get(j).getValuesToEliminate());
                cloneSudokuElement.setValue(this.sudokuRowList.get(i).getSudokuElementList().get(j).getValue());
                cloneSudokuRow.getSudokuElementList().add(cloneSudokuElement);
            }
            cloneSudokuRowList.add(cloneSudokuRow);
        }
    }

}
