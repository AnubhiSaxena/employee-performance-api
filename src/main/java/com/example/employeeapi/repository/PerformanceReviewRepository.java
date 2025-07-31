package com.example.employeeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.PerformanceReview;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
	
    List<PerformanceReview> findTop3ByEmployeeOrderByReviewDateDesc(Employee employee);
}

