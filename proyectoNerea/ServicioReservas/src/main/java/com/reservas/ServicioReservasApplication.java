package com.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.reservas.model")
@EnableJpaRepositories(basePackages = "com.reservas.repository")
@SpringBootApplication(scanBasePackages = {"com.reservas.controller", "com.reservas.service"})
@ComponentScan(basePackages = {"com.reservas.config"})
public class ServicioReservasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicioReservasApplication.class, args);
    }
}
