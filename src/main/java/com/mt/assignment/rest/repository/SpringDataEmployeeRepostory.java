package com.mt.assignment.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mt.assignment.rest.domine.Employee;

public interface SpringDataEmployeeRepostory extends CrudRepository<Employee, String> {

	List<Employee> findEmplyeeeById(Long id);

}
