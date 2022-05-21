package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int idd);

    void save(Employee employee);

    void deleteById(int id);

    List<Employee> findAllByOrderByLastNameAsc();

    List<Employee> findAllByOrderByLastNameDesc();
}
