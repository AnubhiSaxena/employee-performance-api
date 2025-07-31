package com.example.employeeapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.EmployeeDetailsDTO;
import com.example.employeeapi.model.PerformanceReview;
import com.example.employeeapi.model.PerformanceReviewDTO;
import com.example.employeeapi.model.ProjectDTO;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.repository.PerformanceReviewRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private PerformanceReviewRepository reviewRepo;

    @Transactional(readOnly = true)
    public List<Employee> filterEmployees(Optional<String> departments,
                                          Optional<String> projects,
                                          Optional<LocalDate> reviewDate,
                                          Optional<Integer> score) {

        return employeeRepo.findEmployeesWithFilters(departments, projects, reviewDate, score);
    }

    @Transactional(readOnly = true)
    public EmployeeDetailsDTO getEmployeeDetails(Long id) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));

        // Map projects
        List<ProjectDTO> projects = employee.getEmployeeProjects().stream()
                .map(ep -> new ProjectDTO(
                        ep.getProject().getName(),
                        ep.getRole(),
                        ep.getAssignedDate()
                ))
                .collect(Collectors.toList());

        // Map last 3 performance reviews
        List<PerformanceReview> recentReviews = reviewRepo.findTop3ByEmployeeOrderByReviewDateDesc(employee);
        List<PerformanceReviewDTO> reviews = recentReviews.stream()
                .map(r -> new PerformanceReviewDTO(
                        r.getReviewDate(),
                        r.getScore(),
                        r.getReviewComments()
                ))
                .collect(Collectors.toList());

        // Build and return DTO
        return EmployeeDetailsDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment() != null ? employee.getDepartment().getName() : null)
                .manager(employee.getManager() != null ? employee.getManager().getName() : null)
                .dateOfJoining(employee.getDateOfJoining())
                .salary(employee.getSalary())
                .projects(projects)
                .lastThreeReviews(reviews)
                .build();
    }
}
