package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee>searchSalary(int s,int e) {
		if(repo.findSalaryRange(s, e).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		return repo.findSalaryRange(s, e);
	}
}
