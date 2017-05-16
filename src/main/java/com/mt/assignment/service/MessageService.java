package com.mt.assignment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.mt.assignment.domain.Message;

/**
 * 
 * @author manoj
 *
 */

@Singleton
@Service
public class MessageService {
    List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());

    @PostConstruct
    public void init() {
        messages.add(new Message("Manoj", "Employee Roster"));
        messages.add(new Message("Manoj ", "Spring boot is cool !"));
    }

    public List<Message> getMessages() {
        return messages;
    }
}
