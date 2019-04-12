package com.kodilla.sudoku;

import java.util.List;
import java.util.Scanner;

public class SudokuGame {


    private Scanner scannerSingleton = ScannerSingleton.getInstance();
    private List<SudokuRow> sudokuRowList;
    private SudokuBoard sudokuBoard;
    private SudokuRound sudokuRound = new SudokuRound();

    public SudokuGame() {
        runSudokuRound();

    }

    private void runSudokuRound() {
        boolean nextRound = true;
        while(nextRound) {
            int sudokuTableSize = sudokuRound.getFromUserSudokuTableSize();
            sudokuRowList = sudokuRound.initSudokuBoard(sudokuTableSize);
            sudokuBoard = new SudokuBoard(sudokuRowList);
            drawSudokuTable(sudokuTableSize);
            System.out.println(sudokuBoard.toString());
            System.out.println("Enter - kolejne sudoku / inny przycisk koniec gry:");
            String userInput = scannerSingleton.nextLine();
            if (!userInput.equals("")){
                nextRound = false;
            }
        }
    }

    private void drawSudokuTable() {
        boolean endOfDrawingTable = false;
        while (!endOfDrawingTable) {
            System.out.println("Podaj wiersz, kolumne i wartość (-1 aby wyczyscic komorke)");
            System.out.println("Aby zakonczyc wprowadzanie wpisz: SUDOKU");

            String userInput = scannerSingleton.nextLine();
            if (userInput.equals("SUDOKU")) {
                endOfDrawingTable = true;
                SudokuSolver sudokuSolver = new SudokuSolver();
                sudokuSolver.solve(sudokuBoard);

            } else {
                if (isUserInputCorrect(userInput)) {
                    String[] userInputTable = userInput.split(" ");
                    int rowNumberToInputValue = Integer.parseInt(userInputTable[0]);
                    int colNumberToInputValue = Integer.parseInt(userInputTable[1]);
                    int valueToInput = Integer.parseInt(userInputTable[2]);
                    sudokuBoard.getSudokuOperations().insertValueIntoSudokuTable(rowNumberToInputValue, colNumberToInputValue, valueToInput);
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
                int userInputRow = Integer.parseInt(userInputTable[0]);
                int userInputCol = Integer.parseInt(userInputTable[1]);
                int userInputValue = Integer.parseInt(userInputTable[2]);


                if(userInputRow > sudokuRound.getTableSize() || userInputRow < 1){
                    System.out.println("Numer wiersza powinien byc z zakresu: od 1 do " + sudokuRound.getTableSize());
                    return false;
                }

                if(userInputCol > sudokuRound.getTableSize() || userInputCol < 1){
                    System.out.println("Numer kolumny powinien byc z zakresu: od 1 do " + sudokuRound.getTableSize());
                    return false;
                }

                if(userInputValue != -1 && (userInputValue > 9 || userInputValue < 1)){
                    System.out.println("Wartosc powinna byc z zakresu: od 1 do 9 (lub -1 aby usunac zawartosc komorki)" + sudokuRound.getTableSize());
                    return false;
                }

                if (!sudokuBoard.getSudokuOperations().isInputNumberValid(userInputRow, userInputCol, userInputValue)) {
                    System.out.println("Wprowadzona wartosc juz widnieje w wierszu lub kolumnie lub sekcji");
                    return false;

                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format argumentow");
                return false;
            }

        }

        return true;
    }



    public boolean resolveSudoku() {
        return true;
    }
}
