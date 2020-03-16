package com.v2.MainApp;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.v2.configure.JavaConfig;
import com.v2.data.Employee;
import com.v2.service.EmployeeDao;
import com.v2.service.EmployeeService;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		EmployeeService employeeService = context.getBean(EmployeeService.class);

		EmployeeDao employee1 = context.getBean(EmployeeDao.class);

		employeeService.add(new Employee("Sunil", "suni.bora@example.com", 20000, "IT", "Kalyan"));

		Employee employee = new Employee();
		employee = employee1.findById(4);
		employee.setSalary(700000);
		employee.setName("Dhanshree");
		System.out.println(">>>> " + employee);
		employeeService.update(employee);

		List<Employee> employee2 = employeeService.empList();
		for (Employee emp : employee2) {
			System.out.println("Id = " + emp.getId());
			System.out.println("Name = " + emp.getName());
			System.out.println("Email = " + emp.getEmail());
			System.out.println("Salary = " + emp.getSalary());
			System.out.println("Department" + emp.getDepartment());
			System.out.println("Address" + emp.getAddress());
			System.out.println();
		}

		Employee empDelete = new Employee();
		empDelete = employee1.findById(21);
		employeeService.delete(empDelete);

		context.close();
	}
}
