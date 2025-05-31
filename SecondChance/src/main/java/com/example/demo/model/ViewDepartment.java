package com.example.demo.model;

import java.util.Date;

public class ViewDepartment extends Department {

	private int empcount;

	public ViewDepartment() {
	}

	public ViewDepartment(int id, String name, Date established, int empcount) {
		super(id, name, established);
		this.empcount = empcount;
	}

	public int getEmpcount() {
		return empcount;
	}

	public void setEmpcount(int empcount) {
		this.empcount = empcount;
	}
}
