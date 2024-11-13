package com.vuelos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vuelos.model.Vuelos;
import com.vuelos.service.VuelosService;

/**
 * Controlador REST para gestionar operaciones relacionadas con vuelos.
 * Proporciona endpoints para obtener vuelos con plazas disponibles y realizar
 * reservas de las plazas en vuelos específicos.
 */
@RestController
@RequestMapping("/vuelos")
public class VuelosController {
	@Autowired
	private VuelosService vuelosService;

	/**
	 * Obtiene una lista de vuelos con, al menos, el número especificado de plazas
	 * disponibles.
	 *
	 * @param numeroDePlazas el número mínimo de plazas disponibles requeridas.
	 * @return una lista de objetos {@link Vuelos}.
	 */
	@GetMapping(value = "/numReservar/{numeroDePlazas}", produces = "application/json")
	public List<Vuelos> obtenerVuelosDisponibles(@PathVariable int numeroDePlazas) {
		return vuelosService.getVuelosPorPlazas(numeroDePlazas);
	}

	/**
	 * Reserva un número específico de plazas en un vuelo determinado, si hay
	 * disponibilidad suficiente, restandolo en la bdd.
	 *
	 * @param idVuelo el identificador del vuelo en el que se desean
	 * reservar las plazas.
	 * @param plazasReservadas la cantidad de plazas que se van reservar.
	 * @return un {@link ResponseEntity}.
	 */
	@PutMapping(value = "/{idVuelo}/{plazasReservadas}")
	public ResponseEntity<String> reservarPlazas(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
		boolean exito = vuelosService.reservarPlazas(idVuelo, plazasReservadas);
		if (exito) {
			return ResponseEntity.ok("Reserva exitosa");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("No hay plazas suficientes o vuelo no encontrado");
		}
	}
}
