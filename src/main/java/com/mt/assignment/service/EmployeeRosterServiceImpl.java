package com.mt.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.assignment.rest.domine.Address;
import com.mt.assignment.rest.domine.Employee;
import com.mt.assignment.rest.dto.AddressDTO;
import com.mt.assignment.rest.dto.EmployeeDTO;
import com.mt.assignment.rest.exception.EmploeeRosterException;
import com.mt.assignment.rest.repository.EmployeeRepository;

@Service
public class EmployeeRosterServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRosterServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDTO findEmployeeById(String employeeId) {
		Long id = Long.parseLong(employeeId);
		Employee employee = employeeRepository.findEmplyeeeById(id);
		return assembleDTO(employee);
	}

	public List<EmployeeDTO> findEmployees() {
		List<Employee> employee = employeeRepository.findAll();
		List<EmployeeDTO> dtos = employee.stream().map(emp -> assembleDTO(emp))
				.collect(Collectors.toList());
		return dtos;
	}

	public EmployeeDTO updateEmployees(EmployeeDTO dto, String empId) throws EmploeeRosterException {
		Employee employee = null;

		if (null == empId) {
			throw new EmploeeRosterException("Emploee not exist to update ");
		}
		Long id = Long.parseLong(empId);
		employee = employeeRepository.findEmplyeeeById(id);
		if (null != employee) {
			employee = assemble(dto, employee);
			employee = employeeRepository.save(employee);
		} else {
			throw new EmploeeRosterException("Emploee not exist to update ");
		}

		return assembleDTO(employee);
	}

	public boolean deleteEmployees(String empId) throws EmploeeRosterException {
		Employee employee = null;
		if (null == empId) {
			throw new EmploeeRosterException("Emploee not exist to update ");
		}

		Long id = Long.parseLong(empId);
		employee = employeeRepository.findEmplyeeeById(id);
		if (null != employee) {
			employeeRepository.deleteEmplyeee(employee);
		} else {
			throw new EmploeeRosterException("Emploee not exist to update ");
		}
		return true;
	}

	public EmployeeDTO createEmployees(EmployeeDTO dto) {
		Employee employee = null;
		if (null != dto) {

			Long id = dto.getEmployeeId();
			if (null != id) {
				employee = employeeRepository.findEmplyeeeById(id);
			}
			if (null == employee) {
				employee = new Employee();
				employee = assemble(dto, employee);
				employee = employeeRepository.save(employee);
			}
		}
		return assembleDTO(employee);
	}

	public List<EmployeeDTO> createEmployees(List<EmployeeDTO> dtos) {
		List<EmployeeDTO> employeeDTOs = dtos.stream().map(emp -> createEmployees(emp)).collect(Collectors.toList());
		return employeeDTOs;
	}

	private Employee assemble(EmployeeDTO dto) {
		if (dto == null) {
			return null;
		}
		Address address = null;
		AddressDTO addressDTO = null;
		Employee employee = new Employee();
		employee.setDesignation(dto.getDesignation());
		employee.setName(dto.getName());
		employee.setSalary(dto.getSalary());
		if (null != dto.getAddressDTO()) {
			addressDTO = dto.getAddressDTO();
			address = new Address();
			address.setCity(addressDTO.getCity());
			address.setDoorNo(addressDTO.getDoorNo());
			address.setLocation(addressDTO.getLocation());
			employee.setAddress(address);
		}
		return employee;
	}

	private Employee assemble(EmployeeDTO dto, Employee employee) {
		if (dto == null) {
			return null;
		}
		Address address = null;
		AddressDTO addressDTO = null;
		employee.setDesignation(dto.getDesignation());
		employee.setName(dto.getName());
		employee.setSalary(dto.getSalary());
		if (null != dto.getAddressDTO()) {
			if (null != employee.getAddress()) {
				address = employee.getAddress();
			} else {
				address = new Address();
			}
			addressDTO = dto.getAddressDTO();
			address.setCity(addressDTO.getCity());
			address.setDoorNo(addressDTO.getDoorNo());
			address.setLocation(addressDTO.getLocation());
			employee.setAddress(address);
		}
		return employee;
	}

	private EmployeeDTO assembleDTO(Employee employee) {
		if (employee == null) {
			return null;
		}
		Address address = null;
		AddressDTO adDTO = null;
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getId());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setName(employee.getName());
		employeeDTO.setSalary(employee.getSalary());
		if (null != employee.getAddress()) {
			address = employee.getAddress();
			adDTO = new AddressDTO();
			adDTO.setId(address.getId());
			adDTO.setCity(address.getCity());
			adDTO.setDoorNo(address.getDoorNo());
			adDTO.setLocation(address.getLocation());
			employeeDTO.setAddressDTO(adDTO);
		}
		return employeeDTO;
	}

}
