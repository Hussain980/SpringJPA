package com.v2.serviceImple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.v2.data.Employee;
import com.v2.service.EmployeeDao;

@Repository
public class EmployeeDaoImple implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public void add(Employee emp) {
		em.persist(emp);
	}

	public void update(Employee emp) {
		em.merge(emp);

	}

	/*
	 * public void delete(int id) { //Employee employee=em.find(Employee.class, id);
	 * //System.out.println("???"+employee); em.remove(id);
	 * System.out.println("Deleted Successfully");
	 * 
	 * }
	 */

	public List<Employee> empList() {
		CriteriaQuery<Employee> criteriaQuery = em.getCriteriaBuilder().createQuery(Employee.class);
		@SuppressWarnings("unused")
		Root<Employee> root = criteriaQuery.from(Employee.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	public Employee findById(int id) {
		Employee employee = em.find(Employee.class, id);
		if (employee == null) {
			throw new EntityNotFoundException("Can't find Employee Id" + id);
		}
		return employee;
	}

	public void delete(Employee emp) {
		em.remove(em.contains(emp) ? emp : em.merge(emp));
		System.out.println("Deleted Successfully");
	}

}
