package com.mt.assignment.rest.transform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.mt.assignment.rest.dto.AddressDTO;
import com.mt.assignment.rest.dto.EmployeeDTO;

@Provider
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class HtmlFormToCustomerReader implements MessageBodyReader<EmployeeDTO>{

	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	public EmployeeDTO readFrom(Class<EmployeeDTO> clz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> headers, InputStream in)
			throws IOException, WebApplicationException {
		BufferedReader br=new BufferedReader(new  InputStreamReader(in));
		String line=br.readLine();
		Map<String, String> paramMap=converToMap(line);
		EmployeeDTO employee=new EmployeeDTO();
		employee.setEmployeeId(Long.parseLong( paramMap.get("employeeId")));
		employee.setName(paramMap.get("name"));
		employee.setDesignation(paramMap.get("designation"));
		employee.setSalary(Double.parseDouble( paramMap.get("salary")));
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setDoorNo(paramMap.get("doorNo"));
		addressDTO.setStreet(paramMap.get("street"));
		addressDTO.setCity(paramMap.get("city"));
		employee.setAddressDTO(addressDTO);
		return employee;
	}

	private Map<String, String> converToMap(String line) {
		String[] parameters=line.split("&");
		Map<String, String> paramMap=new HashMap<String, String>();
		for(String parameter:parameters){
			String[] keyValue=parameter.split("=");
			String key=keyValue[0];
			try {
				String value=URLDecoder.decode(keyValue[1],"UTF-8");
				paramMap.put(key, value);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		
		return paramMap;
	}

}
