package com.project.reggioStreet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.project.*"})
//@EnableWebSecurity // it enables this dependency which triggers the login
public class ReggioStreetApplication {

	public static void main(String[] args) {
		// pain
		SpringApplication.run(ReggioStreetApplication.class, args);
	}

}
