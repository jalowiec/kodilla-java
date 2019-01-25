package com.kodilla.stream.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] tab = {1, 3, 5, 6, 9, 11, 15, 17};
        //When
        double result = ArrayOperations.getAverage(tab);
        //Then
        assertEquals(8.375, result, 0.0);
    }
    @Test
    public void testGetAverageEmpty(){
        //Given
        int[] tab = new int[0];
        //When
        double result = ArrayOperations.getAverage(tab);
        //Then
        assertEquals(0.0, result, 0.0);
    }
}
