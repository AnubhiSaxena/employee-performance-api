package com.example.employeeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.*"})
public class EmployeeApiApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApiApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApiApplication.class, args);
        
        LOGGER.info("Employee performance Application Started Successfully !!");
    }
}
