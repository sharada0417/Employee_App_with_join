package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/salary/{a}/{b}")
	public ResponseEntity<List<Employee>>searchBySalary(@PathVariable("a") int s,@PathVariable("b") int e){
		return new ResponseEntity<List<Employee>>
		(service.searchSalary(s, e),HttpStatus.OK);
	}
}
