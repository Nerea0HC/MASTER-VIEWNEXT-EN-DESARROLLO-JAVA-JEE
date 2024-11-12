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

@RestController
@RequestMapping("/vuelos")
public class VuelosController {
    @Autowired
    private VuelosService vuelosService;
    // GET para obtener vuelos con al menos el número de plazas solicitado
    @GetMapping(value = "/numReservar/{numeroDePlazas}", produces = "application/json")
    public List<Vuelos> obtenerVuelosDisponibles(@PathVariable int numeroDePlazas) {
        return vuelosService.getVuelosPorPlazas(numeroDePlazas);
    }

    // PUT para reservar un número de plazas en un vuelo específico
    @PutMapping(value = "/{idVuelo}/{plazasReservadas}")
    public ResponseEntity<String> reservarPlazas(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
        boolean exito = vuelosService.reservarPlazas(idVuelo, plazasReservadas);
        if (exito) {
            return ResponseEntity.ok("Reserva exitossa");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay plazas suficientes o vuelo no encontrado");
        }
    }
}
