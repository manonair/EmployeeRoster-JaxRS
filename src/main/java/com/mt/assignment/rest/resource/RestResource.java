package com.mt.assignment.rest.resource;

import com.mt.assignment.domain.Message;
import com.mt.assignment.service.EmployeeRosterServiceImpl;
import com.mt.assignment.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 
 * @author manoj
 *
 */
@Path("/")
@Component
public class RestResource {

    @Autowired
    private MessageService messageService;

    @Autowired
    private EmployeeRosterServiceImpl service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    public List<Message> message() {
        return messageService.getMessages();
    }
}
