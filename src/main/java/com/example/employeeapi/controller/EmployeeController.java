package com.example.employeeapi.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.EmployeeDetailsDTO;
import com.example.employeeapi.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/filter")
    public List<Employee> filterEmployees(@RequestParam Optional<String> departments,
                                          @RequestParam Optional<String> projects,
                                          @RequestParam Optional<LocalDate> reviewDate,
                                          @RequestParam Optional<Integer> score) {
    	
    	List<String> deptList = departments.map(d -> Arrays.asList(d.split(","))).orElse(Collections.emptyList());
        List<String> projectList = projects.map(p -> Arrays.asList(p.split(","))).orElse(Collections.emptyList());
        
        return employeeService.filterEmployees(departments, projects, reviewDate, score);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }
}
