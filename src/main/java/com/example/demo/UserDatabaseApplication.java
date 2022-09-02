package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableAutoConfiguration
public class UserDatabaseApplication extends SpringBootServletInitializer

{
	public static void main(String[] args)
	
	{
	
		SpringApplication.run(SpringBootApplication.class, args);
	
	}
}
  
  