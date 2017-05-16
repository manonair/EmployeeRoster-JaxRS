package com.mt.assignment.config;

import com.mt.assignment.rest.resource.RestResource;
import com.mt.assignment.service.MessageService;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {RestResource.class, MessageService.class})
public class TestConfig {
}
