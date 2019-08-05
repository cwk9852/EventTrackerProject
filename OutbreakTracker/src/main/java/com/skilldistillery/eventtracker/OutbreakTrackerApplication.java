package com.skilldistillery.eventtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OutbreakTrackerApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OutbreakTrackerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OutbreakTrackerApplication.class, args);
	}

}
