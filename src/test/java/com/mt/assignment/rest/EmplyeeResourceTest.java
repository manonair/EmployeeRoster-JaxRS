package com.mt.assignment.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mt.assignment.config.JerseyConfig;
import com.mt.assignment.config.TestConfig;
import com.mt.assignment.rest.dto.AddressDTO;
import com.mt.assignment.rest.dto.EmployeeDTO;

public class EmplyeeResourceTest extends JerseyTest{

	 @Override
	    protected Application configure() {
	        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
	        return new JerseyConfig()
	                .property("contextConfig", context);
	    }
	@Before
	public void setUp() throws Exception {
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employeeform/multiple";
		WebTarget target=client.target(url);
		List<EmployeeDTO> list =Collections.singletonList(getEmployeeDTO());
		Response response=target.request().post(Entity.html(list));
		assertNotNull(response);
	}
	
	@Test
	public void testPostEmployeeFormEmployeeDTO() {
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employeeform";
		WebTarget target=client.target(url);
		Response response=target.request().post(Entity.json(getEmployeeDTO()));
		assertNotNull(response);
	}

	@Test
	public void testPostEmployeeFormListOfEmployeeDTO() {
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employeeform/multiple";
		WebTarget target=client.target(url);
		List<EmployeeDTO> list =Collections.singletonList(getEmployeeDTO());
		Response response=target.request().post(Entity.html(list));
		assertNotNull(response);
	}
	

	@Test
	public void testGetEmployee() {
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employee/";
		WebTarget target=client.target(url);
		List<EmployeeDTO> dtos=target.request().get(List.class);
		assertNotNull(dtos);
	}

	@Test
	public void testGetEmployeeResponse() {
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employee/1";
		WebTarget target=client.target(url);
		Response response=target.request().get(Response.class);
		assertNotNull(response);
	}

	@Test
	public void testPostEmployeeEmployeeDTO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		
		EmployeeDTO dto= getEmployeeDTO();
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employee/1";
		WebTarget target=client.target(url);
		Response response=target.request().put(Entity.json(dto));
		assertNotNull(response);
	}

	@Test
	public void testDeleteEmployee() {
		EmployeeDTO dto= getEmployeeDTO();
		Client client=ClientBuilder.newClient();
		String url="http://localhost:8586/rest/employee/1";
		WebTarget target=client.target(url);
		Response response=target.request().delete();
		assertNotNull(response);
	}

	@Test
	public void testPostEmployeeListOfEmployeeDTO() {
		fail("Not yet implemented");
	}

	

	private EmployeeDTO getEmployeeDTO() {
		EmployeeDTO employee=new EmployeeDTO();
		employee.setName("Manoj");
		employee.setDesignation("SWE");
		employee.setSalary(3000D);
		AddressDTO addressDTO = new  AddressDTO();
		addressDTO.setDoorNo("M241");
		addressDTO.setStreet("4000 NW ");
		addressDTO.setLocation("GainesVille");
		addressDTO.setCity("FL");
		employee.setAddressDTO(addressDTO);
		return employee;
	}

}
