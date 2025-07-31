package com.example.employeeapi.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String manager;
    private LocalDate dateOfJoining;
    private double salary;

    private List<ProjectDTO> projects;
    private List<PerformanceReviewDTO> lastThreeReviews;

    public record ProjectDTO(String projectName, String role, LocalDate assignedDate) {}
    public record PerformanceReviewDTO(LocalDate reviewDate, int score, String reviewComments) {}

}

