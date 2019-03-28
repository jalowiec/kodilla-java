package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final List<String> tasks;


    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
    }

    public String getTask(int taskNumber){
        return tasks.get(taskNumber);
    }


}
