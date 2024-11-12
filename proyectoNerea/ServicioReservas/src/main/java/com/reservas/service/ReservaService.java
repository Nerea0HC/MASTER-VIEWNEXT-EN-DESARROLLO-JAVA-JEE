package com.reservas.service;

import com.reservas.model.Reserva;

import java.util.List;

public interface ReservaService {
    boolean crearReserva(Reserva reserva);
    List<Reserva> obtenerReservasPorHotel(String nombreHotel);
}
