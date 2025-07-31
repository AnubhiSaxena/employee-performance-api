package com.example.employeeapi.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectDTO {
    private String projectName;
    private String role;
    private LocalDate assignedDate;

    public ProjectDTO() {}

    public ProjectDTO(String projectName, String role, LocalDate assignedDate) {
        this.projectName = projectName;
        this.role = role;
        this.assignedDate = assignedDate;
    }
}