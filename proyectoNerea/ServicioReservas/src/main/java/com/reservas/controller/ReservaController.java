package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.model.Reserva;
import com.reservas.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody Reserva reserva) {
        boolean exito = reservaService.crearReserva(reserva);
        if (exito) {
            return ResponseEntity.ok("Reserva creada con éxito.");
        } else {
            return ResponseEntity.badRequest().body("Error al crear la reserva.");
        }
    }

    @GetMapping("/hotel/{nombreHotel}")
    public List<Reserva> obtenerReservasPorHotel(@PathVariable String nombreHotel) {
        return reservaService.obtenerReservasPorHotel(nombreHotel);
    }
}

