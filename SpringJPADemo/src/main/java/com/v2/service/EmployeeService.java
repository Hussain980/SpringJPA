package com.v2.service;

import java.util.List;

import com.v2.data.Employee;

public interface EmployeeService {
	public void add(Employee emp);
	public void update(Employee emp);
	//public void delete(int id);
	List<Employee> empList();
	public void delete(Employee empDelete);
	public Employee findById(int id);

}
