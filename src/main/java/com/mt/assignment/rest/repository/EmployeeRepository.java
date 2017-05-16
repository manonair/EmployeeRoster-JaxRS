package com.mt.assignment.rest.repository;

import java.util.List;

import com.mt.assignment.rest.domine.Employee;

public interface EmployeeRepository {

	Employee save(Employee employee);

	List<Employee> findAll();

	Employee findEmplyeeeById(Long employeeId);

	void deleteEmplyeee(Employee employee);


}
