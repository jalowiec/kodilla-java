package com.kodilla.sudoku;

import java.util.*;

public class SudokuRound {


    public int  getSudokuTableSize(){
        int result = 0;
        Scanner scannerSingleton = ScannerSingleton.getInstance();
        boolean tableSizeCorrect = false;
        while(!tableSizeCorrect){
            System.out.println("Podaj rozmiar tabeli: 3, 6 lub 9: ");
            if(scannerSingleton.hasNextInt()){
                result = scannerSingleton.nextInt();
                if(isTableSizeCorrect(result)) {
                    tableSizeCorrect = true;
                } else{
                    System.out.println("Podana liczba nie jest z poprawnego zakresu");
                }
            } else {
                String incorrectFormatSize = scannerSingleton.next();
                System.out.println("Podany rozmiar nie jest liczba!");
            }
            scannerSingleton.nextLine();

        }
        return result;
    }

    private boolean isTableSizeCorrect(int tableSize) {
        if (tableSize == 3 || tableSize == 6 || tableSize == 9) {
            return true;
        }
        return false;
    }


    public List<SudokuRow> initSudokuBoard(int sudokuTableSize) {
        List<SudokuRow> sudokuRowList = new ArrayList<>();
        for(int i=0; i<sudokuTableSize; i++){
            SudokuRow sudokuRow = new SudokuRow();
            for(int j=0; j<sudokuTableSize; j++){
                SudokuElement sudokuElement = new SudokuElement();
                sudokuRow.getSudokuElementList().add(sudokuElement);
            }
            sudokuRowList.add(sudokuRow);
        }
        return sudokuRowList;
    }
}
