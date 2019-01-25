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
        assertEquals(3.5, result, 0.0);
    }
}
