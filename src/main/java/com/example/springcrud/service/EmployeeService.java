package com.example.springcrud.service;

import java.util.List;

import com.example.springcrud.implementations.EmployeeInterface;
import com.example.springcrud.model.Employee;
import com.example.springcrud.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService implements EmployeeInterface{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    @Override
    public boolean addEmployee(Employee e) {
        List<Employee> employee = employeeRepository.findByNameAndRole(e.getName(), e.getRole());
        if (employee.size() == 0) {
            employeeRepository.save(e);
            return true;
        }
        return false;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.delete(getEmployeeById(id));
    }
    
}
