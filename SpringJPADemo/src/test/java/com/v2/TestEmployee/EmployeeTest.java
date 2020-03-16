package com.v2.TestEmployee;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.v2.configure.JavaConfig;
import com.v2.data.Employee;
import com.v2.service.EmployeeDao;
import com.v2.service.EmployeeService;

public class EmployeeTest 
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
	EmployeeService employeeService = context.getBean(EmployeeService.class);
	EmployeeDao employee1 = context.getBean(EmployeeDao.class);

	@Test
	public void addEmp(){
		Employee employee=new Employee();
		employee.setName("Nazim");
		employee.setEmail("xyz@example.com");
		employee.setSalary(50000);
		employee.setDepartment("IT");
		employee.setAddress("Mumbai");
		
		employeeService.add(employee);
	}
	
	@Test
	public void showEmployee()
	{
		List<Employee> employee = employeeService.empList();
		for (Employee emp : employee) {
			System.out.println("Id = " + emp.getId());
			System.out.println("Name = " + emp.getName());
			System.out.println("Email = " + emp.getEmail());
			System.out.println("Salary = " + emp.getSalary());
			System.out.println("Department" + emp.getDepartment());
			System.out.println("Address" + emp.getAddress());
			System.out.println();
		}
	}
	
	@Test
    public void update()
    {
            Employee employee = new Employee();
            //employee = employee1.findById(30);
            employee = employeeService.findById(3);
            employee.setSalary(22000);
            employee.setName("Divya");
            //System.out.println(">>>> " + employee);
            employeeService.update(employee);
    }
    
	/*
	 * @Test public void delete() { Employee empDelete = new Employee(); empDelete =
	 * employeeService.findById(1 ); employeeService.delete(empDelete); }
	 */
}
