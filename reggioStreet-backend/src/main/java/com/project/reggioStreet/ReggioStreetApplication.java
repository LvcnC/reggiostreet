package com.project.reggioStreet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.project.*"})
public class ReggioStreetApplication {

	public static void main(String[] args) {
		// pain
		SpringApplication.run(ReggioStreetApplication.class, args);
	}

}
