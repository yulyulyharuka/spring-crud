package com.example.springcrud;

import java.util.List;

import com.example.springcrud.service.EmployeeService;
import com.example.springcrud.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class Controller {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> res = employeeService.getAllEmployees();
            return new ResponseEntity<List<Employee>>(res,HttpStatus.OK);
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/id/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
        try {
            Employee e = employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<Employee>(e,HttpStatus.OK);
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/role/{employeeRole}")
    public ResponseEntity<List<Employee>> getEmployeeByRole(@PathVariable String employeeRole) {
        try {
            List<Employee> e = employeeService.getEmployeesByRole(employeeRole);
            return new ResponseEntity<List<Employee>>(e,HttpStatus.OK);
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.addEmployee(employee);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long employeeId) {
        try {
            employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
