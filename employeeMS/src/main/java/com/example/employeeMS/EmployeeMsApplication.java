package com.example.employeeMS;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.ui.ModelMap;

@SpringBootApplication
public class EmployeeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
