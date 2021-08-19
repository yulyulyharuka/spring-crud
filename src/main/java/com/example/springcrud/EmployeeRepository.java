package com.example.springcrud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Optional<Employee> findById(Long id);
    List<Employee> findAll();

    @Query("SELECT e FROM employees e WHERE e.role = :role")
    List<Employee> findByRole(@Param("role") String role);
}
