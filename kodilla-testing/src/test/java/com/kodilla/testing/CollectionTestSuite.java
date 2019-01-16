package com.kodilla.testing;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test case - poczatek");
    }
    @After
    public void after(){
        System.out.println("Test Case - koniec");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> emptyArrayList = new ArrayList<>();
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(emptyArrayList);
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList (){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> exampleArrayList = new ArrayList<>();
        for(int i=-10; i<= 10; i++){
            exampleArrayList.add(i);
        }
        ArrayList<Integer> paternArrayList = new ArrayList<>();
        for(int i=-10; i<= 10; i++){
            if(i % 2 == 0) {
                paternArrayList.add(i);
            }
        }
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(exampleArrayList);
        //Then
        Assert.assertEquals(paternArrayList, result);
    }

}
