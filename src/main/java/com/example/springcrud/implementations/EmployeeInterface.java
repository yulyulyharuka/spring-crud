package com.example.springcrud.implementations;

import java.util.List;
import com.example.springcrud.model.Employee;

public interface EmployeeInterface {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    List<Employee> getEmployeesByRole(String role);
    boolean addEmployee(Employee e);
    void deleteEmployeeById(Long id);
}
