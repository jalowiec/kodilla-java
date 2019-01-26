package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;
import portfolio.Task;
import portfolio.TaskList;
import portfolio.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class BoardTestSuite {
    public com.kodilla.stream.portfolio.Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        com.kodilla.stream.portfolio.Board project = new com.kodilla.stream.portfolio.Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();
        //When
        User user1 = new User("developer1", "John Smith");
        List<Task> taskForDeveloper1 = project.getTaskLists()
                .stream()
                .flatMap(p->p.getTasks().stream())
                .filter(p->p.getAssignedUser().equals(user1))
                .collect(toList());
        //Then
        assertEquals(2, taskForDeveloper1.size());
        assertEquals(user1, taskForDeveloper1.get(0).getAssignedUser());
        assertEquals(user1, taskForDeveloper1.get(1).getAssignedUser());

    }
    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }
    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }
    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        OptionalDouble avgTasksTime = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(l->l.getTasks().stream())
                .map(t-> ChronoUnit.DAYS.between(t.getCreated(), LocalDate.now()))
                .mapToInt(l->l.intValue())
                .average();

        //Then
        assertEquals(10, avgTasksTime.orElse(0), 0.00);

    }

    @Test
    public void testAddTaskListAverageWorkingOnTaskEmpty(){
        //Given
        com.kodilla.stream.portfolio.Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasksEmpty = new ArrayList<>();
        inProgressTasksEmpty.add(new TaskList("In progress Empty"));
        OptionalDouble avgTasksTime = project.getTaskLists().stream()
                .filter(inProgressTasksEmpty::contains)
                .flatMap(l->l.getTasks().stream())
                .map(t-> ChronoUnit.DAYS.between(t.getCreated(), LocalDate.now()))
                .mapToInt(l->l.intValue())
                .average();

        //Then
        assertEquals(0, avgTasksTime.orElse(0), 0.00);

    }


}

