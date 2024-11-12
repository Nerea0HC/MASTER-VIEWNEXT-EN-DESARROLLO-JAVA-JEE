package com.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages="com.vuelos.model")
@EnableJpaRepositories(basePackages="com.vuelos.repository")
@SpringBootApplication(scanBasePackages= {"com.vuelos.controller", "com.vuelos.service"})
public class ServicioVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVuelosApplication.class, args);
	}

}
