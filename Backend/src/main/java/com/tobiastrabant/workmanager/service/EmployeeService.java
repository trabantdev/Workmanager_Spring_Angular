package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int idd);

    public void save(Employee employee);

    public void deleteById(int id);
}
