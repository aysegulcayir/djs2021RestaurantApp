package com.restaurant.reservationApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(){
    }
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id", required = true) long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/employee", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
}
