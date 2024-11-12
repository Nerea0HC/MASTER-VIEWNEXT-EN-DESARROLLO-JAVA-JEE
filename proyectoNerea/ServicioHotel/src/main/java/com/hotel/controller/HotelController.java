package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	// Especificamos ruta obtener todos los hoteles disponibles
	@GetMapping(value = "/disponibles", produces = "application/json")
	public List<Hotel> getHotelesDisponibles() {
		return hotelService.getHotelesDisponibles();
	}

	// GET para obtener hotel por nombre
	@GetMapping(value = "/nombre/{nombre}", produces = "application/json")
	public ResponseEntity<Hotel> obtenerHotelPorNombre(@PathVariable String nombre) {
		Hotel hotel = hotelService.getHotelPorNombre(nombre);
		if (hotel != null) {
			return ResponseEntity.ok(hotel);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
