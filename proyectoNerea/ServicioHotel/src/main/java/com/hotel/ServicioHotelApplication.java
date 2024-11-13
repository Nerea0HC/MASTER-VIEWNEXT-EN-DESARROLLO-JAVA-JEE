package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages="com.hotel.model")
@EnableJpaRepositories(basePackages="com.hotel.repository")
@SpringBootApplication(scanBasePackages= {"com.hotel.controller", "com.hotel.service"})
public class ServicioHotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicioHotelApplication.class, args);
    }
}