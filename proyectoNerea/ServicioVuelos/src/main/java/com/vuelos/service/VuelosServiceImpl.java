package com.vuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuelos.model.Vuelos;
import com.vuelos.repository.VuelosRepository;

@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	private VuelosRepository vuelosRepository;

	@Override
	public List<Vuelos> getVuelosPorPlazas(int numeroDePlazas) {
		return vuelosRepository.findByPlazasDisponiblesGreaterThanEqual(numeroDePlazas);
	}

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
