package com.example.demo.repo;

import com.example.demo.model.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer>{
	//JPQL
	@Query("select name from Department")
	public List<String > getDeptNames();
	
	@Query("select d "
			+ "from Department d"
			+"where d.name like %?%")
	public List<Department> searchName(String name);
	
	// display departments along with number of employees working there
		/*
		 * dept name:HR 
		 * no_emp:5
		 * 
		 */
	@Query("select count(*) from Department d"
			+ "join d.employees"
			+ "where d.id =?1")
	public int numberofEmp(int did);
}
