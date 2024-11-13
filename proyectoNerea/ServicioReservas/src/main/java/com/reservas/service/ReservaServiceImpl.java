package com.reservas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.reservas.model.Reserva;
import com.reservas.repository.ReservaRepository;

/**
 * Implementación del servicio de reservas que maneja la lógica de negocio para
 * crear y obtener reservas, comunicandose con los microservicios para hacer las
 * comrpobaciones necesarias.
 */
@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	/** RestTemplate para realizar solicitudes HTTP. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * URL del servicio externo de hoteles para validar la disponibilidad del hotel.
	 */
	private final String URL_SERVICIO_HOTELES = "http://localhost:8081/hoteles/id/";

	/** URL del servicio externo de vuelos para realizar reservas de vuelo. */
	private final String URL_SERVICIO_VUELOS = "http://localhost:8082/vuelos/{idVuelo}/{plazasReservadas}";

	/**
	 * Crea una nueva reserva verificando la disponibilidad del hotel y vuelo
	 * asociado
	 *
	 * @param reserva el objeto {@link Reserva} con los detalles de la reserva a
	 * crear.
	 * @return {@code true} si la reserva se creó exitosamente y se guardó en el
	 * repositorio.
	 */
	@Override
	public boolean crearReserva(Reserva reserva) {
		// Verificar disponibilidad del hotel
		String urlHotel = URL_SERVICIO_HOTELES + reserva.getIdHotel();
		var hotelResponse = restTemplate.getForObject(urlHotel, String.class);
		if (hotelResponse == null) {
			return false;
		}
		// Verificar disponibilidad del vuelo y realizar reserva
		String urlVuelo = URL_SERVICIO_VUELOS.replace("{idVuelo}", String.valueOf(reserva.getIdVuelo()))
				.replace("{plazasReservadas}", String.valueOf(reserva.getPersonas()));

		var vueloResponse = restTemplate.exchange(urlVuelo, HttpMethod.PUT, null, String.class);

		if (vueloResponse.getStatusCode().is2xxSuccessful()) {
			reservaRepository.save(reserva);
			return true;
		}
		return false;
	}

	/**
	 * Obtiene una lista de reservas asociadas a un hotel específico.
	 *
	 * @param nombreHotel el nombre del hotel cuyas reservas se desean obtener.
	 * @return una lista de objetos {@link Reserva} que representa las reservas del
	 *         hotel especificado.
	 */
	@Override
	public List<Reserva> obtenerReservasPorHotel(String nombreHotel) {
		// Obtener el ID del hotel a partir del nombre
		String urlHotel = URL_SERVICIO_HOTELES + nombreHotel;
		var hotelResponse = restTemplate.getForObject(urlHotel, String.class);

		// Convertir el ID del hotel y recuperar las reservas
		int idHotel = Integer.parseInt(hotelResponse);
		return reservaRepository.findByIdHotel(idHotel);
	}
}
