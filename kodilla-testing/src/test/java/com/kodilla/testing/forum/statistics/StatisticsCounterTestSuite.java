package com.kodilla.testing.forum.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCounterTestSuite {

    @Test
    public void testCalculateAdvStatisticsWithMock(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("AstroBoy");
        usersNames.add("BladeDancer");
        usersNames.add("Entropy");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3, statisticsCounter.getUsersNumber());
        assertEquals(100, statisticsCounter.getPostsNumber());
        assertEquals(200, statisticsCounter.getCommentsNumber());
        assertEquals(33.33, statisticsCounter.getPostsPerUserAvgNumber(), 0.01);
        assertEquals(66.66, statisticsCounter.getCommentsPerUserAvgNumber(), 0.01);
        assertEquals(2.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWithMockWithZeroActivity(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("AstroBoy");
        usersNames.add("BladeDancer");
        usersNames.add("Entropy");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3, statisticsCounter.getUsersNumber());
        assertEquals(0, statisticsCounter.getPostsNumber());
        assertEquals(0, statisticsCounter.getCommentsNumber());
        assertEquals(0.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

    @Test
    // czy jak jest zero uzytkownikow to znaczy ze liczba postow i komentarzy tez ma byc zero?
    public void testCalculateAdvStatisticsWithMockWithZeroUsers(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, statisticsCounter.getUsersNumber());
        assertEquals(50, statisticsCounter.getPostsNumber());
        assertEquals(10, statisticsCounter.getCommentsNumber());
        assertEquals(0.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.20, statisticsCounter.getCommentsPerPostAvgNumber(), 0.01);
    }

    @Test
    // czy jak jest zero uzytkownikow to znaczy ze liczba postow i komentarzy tez ma byc zero?
    public void testCalculateAdvStatisticsWithMockWithGreatActivity(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++){
            usersNames.add(new String());
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, statisticsCounter.getUsersNumber());
        assertEquals(1000, statisticsCounter.getPostsNumber());
        assertEquals(10000, statisticsCounter.getCommentsNumber());
        assertEquals(10.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.01);
        assertEquals(100.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.01);
        assertEquals(10.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.01);
    }

}
