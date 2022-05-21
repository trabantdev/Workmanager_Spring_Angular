package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.dao.ProjectRepository;
import com.tobiastrabant.workmanager.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImplementation implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) {
        Optional<Project> result = projectRepository.findById(id);

        if (result.isPresent()) {
            Project project = result.get();
            return project;
        }
        else {
            throw new RuntimeException("Could not find employee with id - " + id);
        }
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }
}
