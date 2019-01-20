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
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3, statisticsCounter.getUsersNumber());
        assertEquals(1000, statisticsCounter.getPostsNumber());
        assertEquals(2000, statisticsCounter.getCommentsNumber());
        assertEquals(333.33, statisticsCounter.getPostsPerUserAvgNumber(), 0.01);
        assertEquals(666.66, statisticsCounter.getCommentsPerUserAvgNumber(), 0.01);
        assertEquals(2.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

    @Test
    public void testCalculateAdvStatisticsWithMockWithEmptyStatistic(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, statisticsCounter.getUsersNumber());
        assertEquals(0, statisticsCounter.getPostsNumber());
        assertEquals(0, statisticsCounter.getCommentsNumber());
        assertEquals(0.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
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
    public void testCalculateAdvStatisticsWithMockWithZeroComments(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("AstroBoy");
        usersNames.add("BladeDancer");
        usersNames.add("Entropy");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3, statisticsCounter.getUsersNumber());
        assertEquals(1000, statisticsCounter.getPostsNumber());
        assertEquals(0, statisticsCounter.getCommentsNumber());
        assertEquals(333.33, statisticsCounter.getPostsPerUserAvgNumber(), 0.01);
        assertEquals(0.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

    @Test
    public void testCalculateAdvStatisticsWithMockWithZeroPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("AstroBoy");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(31);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(1, statisticsCounter.getUsersNumber());
        assertEquals(0, statisticsCounter.getPostsNumber());
        assertEquals(31, statisticsCounter.getCommentsNumber());
        assertEquals(0.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.00);
        assertEquals(31.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.00, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

    @Test
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
        assertEquals(0.20, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

    @Test
    public void testCalculateAdvStatisticsWithMockWithGreatActivity(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i=0; i<100; i++){
            usersNames.add(new String());
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(10000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        StatisticsCounter statisticsCounter = new StatisticsCounter();

        //When
        statisticsCounter.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, statisticsCounter.getUsersNumber());
        assertEquals(10000, statisticsCounter.getPostsNumber());
        assertEquals(1000, statisticsCounter.getCommentsNumber());
        assertEquals(100.00, statisticsCounter.getPostsPerUserAvgNumber(), 0.00);
        assertEquals(10.00, statisticsCounter.getCommentsPerUserAvgNumber(), 0.00);
        assertEquals(0.10, statisticsCounter.getCommentsPerPostAvgNumber(), 0.00);
    }

}
