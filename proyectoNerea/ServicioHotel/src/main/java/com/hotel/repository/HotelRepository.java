package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.hotel.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	/**
	 * Método parra obtener hoteles disponibles
	 */
	List<Hotel> findByDisponibleTrue();

	/**
	 * Método para encontrar hotel por nombree
	 */
	Hotel findByNombre(String nombre);
}
