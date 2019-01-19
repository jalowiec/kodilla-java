package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test case - poczatek");
    }
    @After
    public void after(){
        System.out.println("Test Case - koniec");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
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
        Integer[] patternArray = {-10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10};
        List<Integer> expectedList = Arrays.asList(patternArray);

        ArrayList<Integer> exampleArrayList = new ArrayList<>();
        for(int i=-10; i<= 10; i++){
            exampleArrayList.add(i);
        }
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(exampleArrayList);
        //Then
        Assert.assertEquals(expectedList, result);
    }

}
