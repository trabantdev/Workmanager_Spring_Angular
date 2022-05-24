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

        if (result.isPresent()) {
            Employee employee = result.get();
            return employee;
        }
        else {
            throw new RuntimeException("Could not find employee with id - " + id);
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
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
    public List<Employee> findByLastNameOrderByFirstNameAsc(String lastName) {
        return employeeRepository.findByLastNameOrderByFirstNameAsc(lastName);
    }

    @Override
    public List<Employee> findByLastNameOrderByFirstNameDesc(String lastName) {
        return employeeRepository.findByLastNameOrderByFirstNameDesc(lastName);
    }
    @Override
    public List<Employee> findByLastNameOrderByLastNameAsc(String lastName) {
        return employeeRepository.findByLastNameOrderByLastNameAsc(lastName);
    }

    @Override
    public List<Employee> findByLastNameOrderByLastNameDesc(String lastName) {
        return employeeRepository.findByLastNameOrderByLastNameDesc(lastName);
    }

    @Override
    public List<Employee> findByFirstNameOrderByFirstNameAsc(String firstName) {
        return employeeRepository.findByFirstNameOrderByFirstNameAsc(firstName);
    }

    @Override
    public List<Employee> findByFirstNameOrderByFirstNameDesc(String firstName) {
        return employeeRepository.findByFirstNameOrderByFirstNameDesc(firstName);
    }

    @Override
    public List<Employee> findByFirstNameOrderByLastNameAsc(String firstName) {
        return employeeRepository.findByFirstNameOrderByLastNameAsc(firstName);
    }

    @Override
    public List<Employee> findByFirstNameOrderByLastNameDesc(String firstName) {
        return employeeRepository.findByFirstNameOrderByLastNameDesc(firstName);
    }

    @Override
    public List<Employee> findByEmailAddress(String email) {
        return employeeRepository.findByEmail(email);
    }
}
