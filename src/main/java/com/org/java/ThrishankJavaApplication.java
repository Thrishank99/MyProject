package com.org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.org.java.designpattern.FactoryNotification;
import com.org.java.designpattern.Notification;
import com.org.java.designpattern.SingletonTest;


@SpringBootApplication
public class ThrishankJavaApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ThrishankJavaApplication.class);
	}


	public static void main(String[] args) {  
		SpringApplication.run(ThrishankJavaApplication.class, args);
		
		
	}

}
