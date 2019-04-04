package com.kodilla.sudoku;

import java.util.List;
import java.util.Scanner;

public class SudokuGame {


    Scanner scannerSingleton = ScannerSingleton.getInstance();
    int sudokuTableSize;
    List<SudokuRow> sudokuRowList;
    SudokuBoard sudokuBoard;

    public SudokuGame() {
        startSudokuRound();
        drawSudokuTable();
    }

    private void startSudokuRound(){
        SudokuRound sudokuRound = new SudokuRound();
        sudokuTableSize = sudokuRound.getSudokuTableSize();
        sudokuRowList = sudokuRound.initSudokuBoard(sudokuTableSize);
        sudokuBoard = new SudokuBoard(sudokuRowList);
        System.out.println(sudokuBoard.toString());
    }

    private void drawSudokuTable(){
        boolean endOfDrawingTable = false;
        while(!endOfDrawingTable){
            System.out.println("Podaj wiersz, kolumne i wartość .");
            System.out.println("Aby zakonczyc wprowadzanie wpisz: SUDOKU");

            String userInput = scannerSingleton.nextLine();
            if(userInput.equals("SUDOKU")){
                endOfDrawingTable = true;
            }else{
                if(isUserInputCorrect(userInput)){
                    String[] userInputTable = userInput.split(" ");
                    int rowNumberToInputValue = Integer.parseInt(userInputTable[0]);
                    int colNumberToInputValue = Integer.parseInt(userInputTable[1]);
                    int valueToInput = Integer.parseInt(userInputTable[2]);
                    insertValueFromUserIntoSudokuTable(rowNumberToInputValue-1, colNumberToInputValue-1, valueToInput);
                    System.out.print(sudokuBoard.toString());
                }
            }
        }
    }

    private boolean isUserInputCorrect(String userInput) {
        String[] userInputTable = userInput.split(" ");
        if (userInputTable.length != 3) {
            System.out.println("Niepoprawna liczba argumentow");
            return false;
        } else {
            try {
                for (int i = 0; i < userInputTable.length; i++) {
                    int userImputNumber = Integer.parseInt(userInputTable[i]);
                    if(i==2 && userImputNumber == -1){
                        //clearing element
                    }
                    else if(userImputNumber > sudokuTableSize || userImputNumber < 1) {
                        System.out.println("Podane liczby powinny być z zakresu: od 1 do " + sudokuTableSize);
                        return false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format argumentow");
                return false;
            }

        }

        return true;
    }

    private void insertValueFromUserIntoSudokuTable(int rowNumber, int colNumber, int value){
        sudokuBoard.getSudokuRowList().get(rowNumber).getSudokuElementList().get(colNumber).setValue(value);
    }

    public boolean resolveSudoku(){
        return true;
    }
}
