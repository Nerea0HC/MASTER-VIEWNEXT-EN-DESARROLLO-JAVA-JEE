package com.vuelos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vuelos.model.Vuelos;
import com.vuelos.repository.VuelosRepository;

/**
 * Implementación del servicio de vuelos que gestiona la consulta de
 * disponibilidad de plazas en vuelos y la reserva.
 */
@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	private VuelosRepository vuelosRepository;

	/**
	 * Obtiene una lista de vuelos con disponibilidad de plazas igual o mayor al
	 * número especificado.
	 *
	 * @param numeroDePlazas el número mínimo de plazas disponibles requeridas.
	 * @return una lista de objetos {@link Vuelos}.
	 */
	@Override
	public List<Vuelos> getVuelosPorPlazas(int numeroDePlazas) {
		return vuelosRepository.findByPlazasDisponiblesGreaterThanEqual(numeroDePlazas);
	}

	/**
	 * Reserva una cantidad específica de plazas en un vuelo determinado, si hay
	 * disponibilidad.
	 *
	 * @param idVuelo el identificador del vuelo en el que se desean reservar las plazas.
	 * @param plazasReservadas la cantidad de plazas que se desea reservar.
	 * @return {@code true} si la reserva se realizó con éxito, o {@code false} si
	 * no hay suficiente.
	 */
	@Override
	public boolean reservarPlazas(int idVuelo, int plazasReservadas) {
		Vuelos vuelo = vuelosRepository.findById(idVuelo).orElse(null);
		if (vuelo != null && vuelo.getPlazasDisponibles() >= plazasReservadas) {
			vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
			vuelosRepository.save(vuelo);
			return true;
		}
		return false;
	}
}
