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

    List<Employee> findByLastnameOrderByFirstNameAsc(String lastname);

    List<Employee> findByLastnameOrderByFirstNameDesc(String lastname);

    List<Employee> findByLastnameOrderByLastNameAsc(String lastname);

    List<Employee> findByLastnameOrderByLastNameDesc(String lastname);

    List<Employee> findByFirstNameOrderByFirstNameAsc(String firstname);

    List<Employee> findByFirstNameOrderByFirstNameDesc(String firstname);

    List<Employee> findByFirstNameOrderByLastNameAsc(String firstname);

    List<Employee> findByFirstNameOrderByLastNameDesc(String firstname);

    List<Employee> findByEmailAddress(String email);
}
