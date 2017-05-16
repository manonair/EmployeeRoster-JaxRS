package com.mt.assignment.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String doorNo;
	private String street;
	private String location;
	private String city;

	public AddressDTO(Long id, String doorNo, String street, String location, String city) {
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

	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
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

}
