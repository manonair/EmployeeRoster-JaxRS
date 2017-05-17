package com.mt.assignment;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mt.assignment.config.JerseyConfig;


/**
 * 
 * @author manoj
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.mt.assignment")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(Application.class)
                .run(args);
        
        logger.info("#-------------- Employee Roster --------------#");
        logger.info("POST http://localhost:8586/rest/employee/multiple");
        logger.info("POST http://localhost:8586/rest/employee/");
        logger.info("");
        logger.info("DELETE : http://localhost:8586/rest/employee/1");
        logger.info("PUT http://localhost:8586/rest/employee/2");
        logger.info("");
        logger.info("GET  http://localhost:8586/rest/employee/");
        logger.info("GET http://localhost:8586/rest/employee/1");
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }
}
