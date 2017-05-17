package com.mt.assignment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mt.assignment.rest.resource.EmplyeeResource;


@Configuration
@ComponentScan(basePackageClasses = {EmplyeeResource.class})
public class TestConfig {
}
