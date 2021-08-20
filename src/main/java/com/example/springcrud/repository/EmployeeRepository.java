package com.example.springcrud.repository;

import java.util.List;
import java.util.Optional;

import com.example.springcrud.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    List<Employee> findByRole(String role);
    List<Employee> findByNameAndRole(String name, String role);
}
