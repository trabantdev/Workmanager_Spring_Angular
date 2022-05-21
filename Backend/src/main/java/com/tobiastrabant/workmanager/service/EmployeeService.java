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

    List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

    List<Employee> findByLastNameOrderByFirstNameDesc(String lastName);

    List<Employee> findByLastNameOrderByLastNameAsc(String lastName);

    List<Employee> findByLastNameOrderByLastNameDesc(String lastName);

    List<Employee> findByFirstNameOrderByFirstNameAsc(String lastName);

    List<Employee> findByFirstNameOrderByFirstNameDesc(String firstName);

    List<Employee> findByFirstNameOrderByLastNameAsc(String firstName);

    List<Employee> findByFirstNameOrderByLastNameDesc(String firstName);

    List<Employee> findByEmailAddress(String email);
}
