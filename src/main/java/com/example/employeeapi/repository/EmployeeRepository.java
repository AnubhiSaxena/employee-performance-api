package com.example.employeeapi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeeapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT DISTINCT e FROM Employee e " +
		       "JOIN e.department d " +
		       "JOIN e.employeeProjects ep " +
		       "JOIN ep.project p " +
		       "JOIN PerformanceReview r ON r.employee = e " +
		       "WHERE (:departments IS NULL OR LOWER(d.name) IN :departments) " +
		       "AND (:projects IS NULL OR LOWER(p.name) IN :projects) " +
		       "AND (:reviewDate IS NULL OR r.reviewDate = :reviewDate) " +
		       "AND (:score IS NULL OR r.score = :score)")
		List<Employee> findEmployeesWithFilters(
		    @Param("departments") Optional<String> departments,
		    @Param("projects") Optional<String> projects,
		    @Param("reviewDate") Optional<LocalDate> reviewDate,
		    @Param("score") Optional<Integer> score
		);

}
