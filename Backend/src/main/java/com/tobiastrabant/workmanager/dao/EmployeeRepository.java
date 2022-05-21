package com.tobiastrabant.workmanager.dao;

import com.tobiastrabant.workmanager.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();
    List<Employee> findAllByOrderByLastNameDesc();

    List<Employee> findByLastNameOrderByFirstNameAsc(String lastname);

    List<Employee> findByLastNameOrderByFirstNameDesc(String lastname);

    List<Employee> findByLastNameOrderByLastNameAsc(String lastname);

    List<Employee> findByLastNameOrderByLastNameDesc(String lastname);

    List<Employee> findByFirstNameOrderByFirstNameAsc(String firstname);

    List<Employee> findByFirstNameOrderByFirstNameDesc(String firstname);

    List<Employee> findByFirstNameOrderByLastNameAsc(String firstname);

    List<Employee> findByFirstNameOrderByLastNameDesc(String firstname);

    List<Employee> findByEmail(String email);
}
