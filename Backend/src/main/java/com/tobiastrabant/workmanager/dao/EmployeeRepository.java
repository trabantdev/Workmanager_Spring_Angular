package com.tobiastrabant.workmanager.dao;

import com.tobiastrabant.workmanager.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
