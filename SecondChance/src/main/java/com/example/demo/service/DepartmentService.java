package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    public List<Department> getDepts() {
        return repo.findAll();
    }

    public Department getDept(int id) {
        return repo.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Department with ID " + id + " not found"));
    }

    public String addDept(Department department) {
        if (repo.findById(department.getId()).isPresent()) {
            throw new DuplicateKeyException("Department ID already exists");
        }
        repo.save(department);
        return "New department added";
    }

    public String updateDept(Department department) {
        if (!repo.existsById(department.getId())) {
            throw new EntityNotFoundException("Department with ID " + department.getId() + " not found");
        }
        repo.save(department);
        return "Department updated successfully";
    }

    public String deleteDept(int id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Department with ID " + id + " not found");
        }
        repo.deleteById(id);
        return "Department deleted successfully";
    }
}
