package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reservas.model.Reserva;
import com.reservas.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private RestTemplate restTemplate;
	private final String URL_SERVICIO_HOTELES = "http://localhost:8081/hoteles/nombre/";
	private final String URL_SERVICIO_VUELOS = "http://localhost:8082/vuelos/{idVuelo}/{plazasReservadas}";

	@Override
	public boolean crearReserva(Reserva reserva) {
		// Mirar el ID del hotel
		String urlHotel = URL_SERVICIO_HOTELES + reserva.getIdHotel();
		var hotelResponse = restTemplate.getForObject(urlHotel, String.class);
		if (hotelResponse == null) {
			return false;
		}

		// Verificamos los vuelos y realizamos la reserva
		String urlVuelo = URL_SERVICIO_VUELOS.replace("{idVuelo}", String.valueOf(reserva.getIdVuelo()))
				.replace("{plazasReservadas}", String.valueOf(reserva.getPersonas()));

		var vueloResponse = restTemplate.exchange(urlVuelo, HttpMethod.PUT, null, String.class);

		if (vueloResponse.getStatusCode().is2xxSuccessful()) {
			reservaRepository.save(reserva);
			return true;
		}
		return false;
	}

	@Override
	public List<Reserva> obtenerReservasPorHotel(String nombreHotel) {
		// Obtener el ID del hotel
		String urlHotel = URL_SERVICIO_HOTELES + nombreHotel;
		var hotelResponse = restTemplate.getForObject(urlHotel, String.class);

		// Llamar al servicio de reservas y devolver las reservas del hotel
		int idHotel = Integer.parseInt(hotelResponse);
		return reservaRepository.findByIdHotel(idHotel);
	}
}
