package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @Column(name = "dept_id")
    private int id;

    @Column(nullable = false)
    private String name;

    private Date established;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(int id, String name, Date established) {
        this.id = id;
        this.name = name;
        this.established = established;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablished() {
        return established;
    }

    public void setEstablished(Date established) {
        this.established = established;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
