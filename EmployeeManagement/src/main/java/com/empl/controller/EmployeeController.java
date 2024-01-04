package com.empl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emp.exceptions.EmployeeNotFoundException;
import com.emp.model.Employee;
import com.emp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

 private final EmployeeService employeeService;

 @Autowired
 public EmployeeController(EmployeeService employeeService) {
     this.employeeService = employeeService;
 }
@GetMapping("/{id}")
 public ResponseEntity<Object> getEmployee(@PathVariable Long id) {
 try {
	 Employee employee = employeeService.getEmployeeById(id);
	 
	 return ResponseEntity.ok(employee);
 }
 catch (Exception e) {
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong - " + e.getMessage());
 }
}

 @GetMapping
 public ResponseEntity<Object> getAllEmployees() {
     try {
         List<Employee> employees = employeeService.getAllEmployees();
         return ResponseEntity.ok(employees);
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body("Something went wrong - " + e.getMessage());
     }
 }

 @PostMapping
 public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
     try {
         if (employee != null) {
             employeeService.createEmployee(employee);
             return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
         } else {
             return ResponseEntity.badRequest().body("Invalid request body");
         }
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body("Something went wrong - " + e.getMessage());
     }
 }

 @PutMapping("/{id}")
 public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
     try {
         if (employee != null) {
             employeeService.updateEmployee(id, employee);
             return ResponseEntity.ok("Employee updated successfully");
         } else {
             return ResponseEntity.badRequest().body("Invalid request body");
         }
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body("Something went wrong - " + e.getMessage());
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
     try {
         employeeService.deleteEmployee(id);
         return ResponseEntity.ok("Employee deleted successfully");
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body("Something went wrong - " + e.getMessage());
     }
 }
 
 public void operateNumber(int number){
	 number = 100;
	 if(number > 10){
		 System.out.println("Number is greater than 10");
	 }
	 int a=100, b=5;
	 int c=a/b;
	 System.out.println(c);
 }
}
