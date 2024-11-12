package com.vuelos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuelos.model.Vuelos;

public interface VuelosRepository extends JpaRepository<Vuelos, Integer> {
	// Método para obtener vuelos con al menos el número de plazas puesto
    List<Vuelos> findByPlazasDisponiblesGreaterThanEqual(int numeroDePlazas);
}
