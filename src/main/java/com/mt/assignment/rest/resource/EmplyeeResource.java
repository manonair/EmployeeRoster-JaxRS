package com.mt.assignment.rest.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mt.assignment.rest.dto.EmployeeDTO;
import com.mt.assignment.service.EmployeeRosterServiceImpl;

@Path("/")
@Component
public class EmplyeeResource {

	private static final Logger logger = LoggerFactory.getLogger(EmplyeeResource.class);

	@Autowired
	private EmployeeRosterServiceImpl rosterServiceImpl;

	/**
	 * 1 - Url: /employee Type: GET Description: This will retrieve all the
	 * employees in json array format
	 * 
	 * @param id
	 * @return
	 */
	@Path("/employee/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	@GET
	public List<EmployeeDTO> getEmployee() {
		List<EmployeeDTO> employees = null;
		try {
			employees = rosterServiceImpl.findEmployees();
		} catch (Exception e) {
			return new ArrayList<>();
			/*return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employees Not Found</body></html>").build();*/
		}
		return employees;//Response.status(Status.OK).header("Content-Type", "application/json").entity(employees).build();
	}

	/**
	 * 2) Url: /employee/:id Type: GET Description: This should return a json
	 * object which retrieves the employee object matching with the id, that is
	 * passed through the url.
	 * 
	 * @param employeeDTOs
	 * @return
	 */
	@Path("/employee/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	@GET
	public Response getEmployee(@PathParam("id") String id) {
		logger.info("Inside getEmployee id: {}", id);

		if (StringUtils.isEmpty(id)) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employee Not Found</body></html>").build();
		}
		EmployeeDTO employeeDTO = null;
		try {
			employeeDTO = rosterServiceImpl.findEmployeeById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employee Not Found</body></html>").build();
		}
		return Response.status(Status.OK).header("Content-Type", "text/html").entity(employeeDTO).build();
	}

	/**
	 * 3 - Url: /employee Type: POST Content-Type: application/json
	 * 
	 * @param employeeDTOs
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/employee")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response postEmployee(EmployeeDTO employeeDTOs) throws URISyntaxException {
		if (employeeDTOs == null) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Error creating Employee </body></html>").build();
		}
		logger.info("Inside getEmployee id: {}", employeeDTOs.getDesignation());
		EmployeeDTO employee = null;
		try {
			employee = rosterServiceImpl.createEmployees(employeeDTOs);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Error creating Employee </body></html>").build();
		}
		return Response.created(new URI(employee.getEmployeeId().toString())).build();
				//(Status.OK).header("Content-Type", "text/html").entity(employee).build();
	}

	/**
	 * 4 - Url: /employee/:id Type: PUT Content-Type: application/jsoThis should
	 * update an employee in the resource. The input json object should contain
	 * the new details in json format. The input json object does not need to
	 * contain the id, since it is passed as a parameter
	 * 
	 * @param id
	 * @param employeeDTOs
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateEmployee(@PathParam("id") String id, EmployeeDTO employeeDTOs) throws URISyntaxException {

		if (StringUtils.isEmpty(id)) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employee Not Found</body></html>").build();
		}
		logger.info("Inside getEmployee id: {}", id);
		EmployeeDTO employee;
		try {
			employee = rosterServiceImpl.updateEmployees(employeeDTOs, id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Error in updating Employee!!</body></html>").build();
		}
//		return Response.status(Status.OK).header("Content-Type", "text/html").entity(employee).build();
		return Response.noContent().location(new URI(employee.getEmployeeId().toString())).build();
		
	}

	/**
	 * 5 - Url: /employee/:id Type: DELETE
	 * 
	 * @param id
	 * @return
	 */
	
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteEmployee(@PathParam("id") String id) {
		if (StringUtils.isEmpty(id)) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employee Not Found</body></html>").build();
		}
		logger.info("Inside getEmployee id: {}", id);
		try {
			rosterServiceImpl.deleteEmployees(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Error deleting Employee</body></html>").build();
		}
		return Response.status(Status.OK).build();
	}

	/**
	 * 6 Url: /employee/multiple Type: POST Content-Type: application/json
	 * 
	 * @param employeeDTOs
	 * @return
	 */
	@Path("/employee/multiple")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response postEmployee(List<EmployeeDTO> employeeDTOs) {
		if (null == employeeDTOs) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Employee Not Found</body></html>").build();
		}
		logger.info("Inside getEmployee id: {}", employeeDTOs.size());
		List<EmployeeDTO> employees = null;
		try {
			employees = rosterServiceImpl.createEmployees(employeeDTOs);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).header("Content-Type", "text/html")
					.entity("<html><body>Error creating Employees </body></html>").build();
		}
		return Response.status(Status.OK).header("Content-Type", "text/html").entity(employees).build();

	}

}
