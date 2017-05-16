package com.mt.assignment.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mt.assignment.rest.domine.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SpringDataEmployeeRepostory repostory;

	@Override
	public Employee save(Employee employee) {
		return repostory.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) repostory.findAll();
	}

	@Override
	public Employee findEmplyeeeById(Long employeeId) {
		List<Employee> Emplyeees = repostory.findEmplyeeeById(employeeId);
		if (Emplyeees.isEmpty()) {
			return null;
		}
		return Emplyeees.get(0);
	}

	@Override
	public void deleteEmplyeee(Employee employee) {
		repostory.delete(employee);

	}

}
