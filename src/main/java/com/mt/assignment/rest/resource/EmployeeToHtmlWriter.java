package com.mt.assignment.rest.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.mt.assignment.rest.dto.AddressDTO;
import com.mt.assignment.rest.dto.EmployeeDTO;
/**
 * 
 * @author manoj
 *
 */

@Provider
@Produces(MediaType.TEXT_HTML)
public class EmployeeToHtmlWriter implements MessageBodyWriter<EmployeeDTO>{

	public long getSize(EmployeeDTO arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		return -1;
	}

	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		return true;
	}

	public void writeTo(EmployeeDTO employeeDTO, Class<?> clz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> headers, OutputStream out)
			throws IOException, WebApplicationException {
		
		StringBuilder builder = new StringBuilder();
		AddressDTO addressDTO= employeeDTO.getAddressDTO();
		if(null!=employeeDTO){
			builder.append( "<html><body><h2>");
			builder.append("Employee Id: "+employeeDTO.getEmployeeId());
			builder.append("<br>Name: "+employeeDTO.getName());
				builder.append("<br>Balance: "+employeeDTO.getDesignation());
				builder.append("<br>Balance: "+employeeDTO.getSalary());
			if(null!=addressDTO){
				builder.append("<br>Balance: "+addressDTO.getId());
				builder.append("<br>Balance: "+addressDTO.getDoorNo());
				builder.append("<br>Balance: "+addressDTO.getStreet());
				builder.append("<br>Balance: "+addressDTO.getLocation());
				builder.append("<br>Balance: "+addressDTO.getCity());
			}
			builder.append("</h2></body></html>");
		}
		out.write(builder.toString().getBytes());
	}

}
