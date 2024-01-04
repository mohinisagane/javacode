package com.emp.service;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
 private Map<Long, Employee> employeeMap = new HashMap<>();
 private Long nextId = 1L;

 public Employee getEmployeeById(Long id) {
     return employeeMap.get(id);
 }

 public List<Employee> getAllEmployees() {
     return new ArrayList<>(employeeMap.values());
 }

 public void createEmployee(Employee employee) {
     employee.setId(nextId++);
     employeeMap.put(employee.getId(), employee);
 }

 public void updateEmployee(Long id, Employee employee) {
     if (employeeMap.containsKey(id)) {
         employee.setId(id);
         employeeMap.put(id, employee);
     }
 }

 public void deleteEmployee(Long id) {
     employeeMap.remove(id);
 }
}

