package com.example.employeeapi.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PerformanceReviewDTO {

	 private LocalDate reviewDate;
	    private int score;
	    private String reviewComments;

	    public PerformanceReviewDTO() {}

	    public PerformanceReviewDTO(LocalDate reviewDate, int score, String reviewComments) {
	        this.reviewDate = reviewDate;
	        this.score = score;
	        this.reviewComments = reviewComments;
	    }
	    
}
