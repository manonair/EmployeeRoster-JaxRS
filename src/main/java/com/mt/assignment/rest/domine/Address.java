package com.mt.assignment.rest.domine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "door_No")
	private String doorNo;

	@Column(name = "street")
	private String street;

	@Column(name = "location")
	private String location;

	@Column(name = "city")
	private String city;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "address", cascade = { CascadeType.ALL })
	private List<Employee> employees;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, String doorNo, String street, String location, String city, List<Employee> employees) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.street = street;
		this.location = location;
		this.city = city;
		this.employees = employees;
	}

	public Address(Long id, String doorNo, String street, String location, String city) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.street = street;
		this.location = location;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public String getStreet() {
		return street;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
