package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {


    public SudokuGame() {
        startSudokuRound();
    }

    private void startSudokuRound(){
        SudokuRound sudokuRound = new SudokuRound();
        int sudokuTableSize = sudokuRound.getSudokuTableSize();
        List<SudokuRow> sudokuRowList = sudokuRound.initSudokuBoard(sudokuTableSize);
        SudokuBoard sudokuBoard = new SudokuBoard(sudokuRowList);
        System.out.println(sudokuBoard.toString());
    }

    public boolean resolveSudoku(){
        return true;
    }
}
