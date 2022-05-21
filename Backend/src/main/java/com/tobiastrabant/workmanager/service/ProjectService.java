package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(int id);

    void save(Project project);

    void deleteById(int id);
}
