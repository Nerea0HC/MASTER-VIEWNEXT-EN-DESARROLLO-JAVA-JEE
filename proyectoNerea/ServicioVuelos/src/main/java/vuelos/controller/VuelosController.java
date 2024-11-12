package vuelos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vuelos.model.Vuelos;
import vuelos.service.VuelosService;
import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VuelosController {
    @Autowired
    private VuelosService vuelosService;

    /*
    // GET para obtener vuelos con al menos el número de plazas solicitado
    @GetMapping(value = "/numReservar/{numeroDePlazas}", produces = "application/json")
    public List<Vuelos> obtenerVuelosDisponibles(@PathVariable int numeroDePlazas) {
        return vuelosService.getVuelosPorPlazas(numeroDePlazas);
    }*/
    
    @GetMapping("/{numeroDePlazas}")
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
