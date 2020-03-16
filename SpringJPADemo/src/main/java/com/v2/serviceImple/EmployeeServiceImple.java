package com.v2.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2.data.Employee;
import com.v2.service.EmployeeDao;
import com.v2.service.EmployeeService;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void add(Employee emp) {
		employeeDao.add(emp);
	}

	public void update(Employee emp) {
		System.out.println("ServiceImple called");

//		  Employee employee=employeeDao.findById(1);
//		  System.out.println("Employee Details:"+employee);

		employeeDao.update(emp);
		// employee=employeeDao.findById(employee.getId());
		System.out.println("Updated");
	}

	@Transactional
	public List<Employee> empList() {
		return employeeDao.empList();
	}

	public void delete(Employee empDelete) {
		employeeDao.delete(empDelete);
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

}
