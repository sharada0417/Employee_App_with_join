package com.example.demo.repo;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    // Get all department names
    @Query("SELECT d.name FROM Department d")
    List<String> getDeptNames();

    // Search departments by name using LIKE
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> searchName(String name);

    // Get the number of employees in a department
    @Query("SELECT COUNT(e) FROM Department d JOIN d.employees e WHERE d.id = :did")
    int numberofEmp(int did);
}
