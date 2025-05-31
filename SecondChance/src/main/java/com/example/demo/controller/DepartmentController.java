package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    
    @GetMapping
	public ResponseEntity<List<Department>>getDepts(){
		return new ResponseEntity<List<Department>>
		(service.getDepts(),HttpStatus.OK);
	}
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {
        Department department = service.getDept(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        String message = service.addDept(department);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
