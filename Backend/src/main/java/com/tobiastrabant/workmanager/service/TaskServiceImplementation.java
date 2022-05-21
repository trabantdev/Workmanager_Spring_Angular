package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(int id) {
        return null;
    }

    @Override
    public void save(Task task) {

    }

    @Override
    public void deleteById(int id) {

    }
}
