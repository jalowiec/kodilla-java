package com.kodilla.spring.reader;

import com.kodilla.spring.portfolio.Board;
import com.kodilla.spring.portfolio.BoardConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        String firstToDoTask = "first toDo task";
        String firstInProgressTask = "first inProgress task";
        String firstDoneTask = "first done task";
        board.getToDoList().addTask(firstToDoTask);
        board.getInProgressList().addTask(firstInProgressTask);
        board.getDoneList().addTask(firstDoneTask);
        //Then
        Assert.assertEquals(firstToDoTask, board.getToDoList().getTask(0));
        Assert.assertEquals(firstInProgressTask, board.getInProgressList().getTask(0));
        Assert.assertEquals(firstDoneTask, board.getDoneList().getTask(0));
    }
}
