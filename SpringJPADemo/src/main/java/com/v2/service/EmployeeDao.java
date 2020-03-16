package com.v2.service;

import java.util.List;

import com.v2.data.Employee;

public interface EmployeeDao {
	
	public void add(Employee emp);
	public void update(Employee emp);
	public void delete(Employee emp);
	List<Employee> empList();
	Employee findById(int id);
	
}
