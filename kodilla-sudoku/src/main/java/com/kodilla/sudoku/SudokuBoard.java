package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> sudokuRowList = new ArrayList<>();

    public SudokuBoard(List<SudokuRow> sudokuRowList) {
        this.sudokuRowList = sudokuRowList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<sudokuRowList.size(); i++){
            for(int j=0; j<sudokuRowList.size(); j++) {
                stringBuilder.append(sudokuRowList.get(i).getSudokuElementList().get(j).getValue());
                stringBuilder.append("\t");

            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
