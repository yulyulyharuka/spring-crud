package com.example.springcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Success add employee";
        } catch(IllegalArgumentException err) {
            return "Failed";
        }
    }
}
