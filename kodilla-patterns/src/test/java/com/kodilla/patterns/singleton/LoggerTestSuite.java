package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLogEmptyEntry() {
        //Given
        //When
        Logger.getInstance().log("");
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("", lastLog);
    }

    @Test
    public void testGetLastLogSingleEntry() {
        //Given
        //When
        Logger.getInstance().log("pierwszy wpis do logow");
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("pierwszy wpis do logow", lastLog);
    }

    @Test
    public void testGetLastLogMultipleEntries() {
        //Given
        //When
        Logger.getInstance().log("pierwszy wpis do logow");
        Logger.getInstance().log("drugi wpis do logow");
        Logger.getInstance().log("trzeci wpis do logow");
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("trzeci wpis do logow", lastLog);
    }
}
