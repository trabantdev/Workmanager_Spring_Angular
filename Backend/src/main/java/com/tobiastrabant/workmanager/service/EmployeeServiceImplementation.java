package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.dao.EmployeeRepository;
import com.tobiastrabant.workmanager.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("Could not find employee with id - " + id);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByOrderByLastNameAsc() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public List<Employee> findAllByOrderByLastNameDesc() {
        return employeeRepository.findAllByOrderByLastNameDesc();
    }

    @Override
    public List<Employee> findByLastnameOrderByFirstNameAsc(String lastname) {
        return employeeRepository.findByLastnameOrderByFirstNameAsc(lastname);
    }

    @Override
    public List<Employee> findByLastnameOrderByFirstNameDesc(String lastname) {
        return employeeRepository.findByLastnameOrderByFirstNameDesc(lastname);
    }

    @Override
    public List<Employee> findByLastnameOrderByLastNameAsc(String lastname) {
        return employeeRepository.findByLastnameOrderByLastNameAsc(lastname);
    }

    @Override
    public List<Employee> findByLastnameOrderByLastNameDesc(String lastname) {
        return employeeRepository.findByLastnameOrderByLastNameDesc(lastname);
    }

    @Override
    public List<Employee> findByFirstNameOrderByFirstNameAsc(String firstname) {
        return employeeRepository.findByFirstNameOrderByFirstNameAsc(firstname);
    }

    @Override
    public List<Employee> findByFirstNameOrderByFirstNameDesc(String firstname) {
        return employeeRepository.findByFirstNameOrderByFirstNameDesc(firstname);
    }

    @Override
    public List<Employee> findByFirstNameOrderByLastNameAsc(String firstname) {
        return employeeRepository.findByFirstNameOrderByLastNameAsc(firstname);
    }

    @Override
    public List<Employee> findByFirstNameOrderByLastNameDesc(String firstname) {
        return employeeRepository.findByFirstNameOrderByLastNameDesc(firstname);
    }
}
