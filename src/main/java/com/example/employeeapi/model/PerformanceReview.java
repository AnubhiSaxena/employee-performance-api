package com.example.employeeapi.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PerformanceReview {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;
    private LocalDate reviewDate;
    private int score;
    private String reviewComments;
    // getters and setters
}
