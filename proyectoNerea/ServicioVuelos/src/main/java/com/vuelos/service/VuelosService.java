package com.vuelos.service;

import java.util.List;

import com.vuelos.model.Vuelos;

public interface VuelosService {
    List<Vuelos> getVuelosPorPlazas(int numeroDePlazas);
    boolean reservarPlazas(int idVuelo, int plazasReservadas);
}
