package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

    // Find the employees with the salary range 70000 to 90000
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    public List<Employee> findSalaryRange(int a, int b);

    // Find employees by department ID
    @Query("select e from Employee e where e.department.id = ?1")
    public List<Employee> findByDept(int did);
}
