package com.mt.assignment.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long employeeId;

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String designation;
	private Double salary;
	private AddressDTO addressDTO;

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public Double getSalary() {
		return salary;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public EmployeeDTO(Long id, String name, String designation, Double salary, AddressDTO addressDTO) {
		super();
		this.employeeId = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.addressDTO = addressDTO;
	}

	public void setEmployeeId(Long id) {
		this.employeeId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

}
