package com.tobiastrabant.workmanager.dao;

import com.tobiastrabant.workmanager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
