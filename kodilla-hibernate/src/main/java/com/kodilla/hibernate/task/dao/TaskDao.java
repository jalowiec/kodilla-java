package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);

    @Query
    List<Task> retrieveLongTasks();

    @Query
    List<Task> retrieveShortTasks();

    @Query(nativeQuery = true)
    List<Task> retrieveTasksWithEnoughTime();

}