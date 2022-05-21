package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);
}
