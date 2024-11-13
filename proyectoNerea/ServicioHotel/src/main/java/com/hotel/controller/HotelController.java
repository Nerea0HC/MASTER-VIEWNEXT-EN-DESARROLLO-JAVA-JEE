package com.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

/**
 * Controlador REST para gestionar operaciones relacionadas con hoteles.
 * Proporciona endpoints para obtener hoteles disponibles,
 * buscar hoteles por nombre y por ID.
 */
@RestController
@RequestMapping("/hoteles")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * Obtiene una lista de todos los hoteles disponibles.
     *
     * @return una lista de objetos {@link Hotel} para los hoteles disponibles.
     */
    @GetMapping(value = "/disponibles", produces = "application/json")
    public List<Hotel> getHotelesDisponibles() {
        return hotelService.getHotelesDisponibles();
    }

    /**
     * Obtiene un hotel por su nombre.
     *
     * @param nombre el nombre del hotel a buscar.
     * @return un {@link ResponseEntity} que contiene el objeto {@link Hotel}.
     */
    @GetMapping(value = "/nombre/{nombre}", produces = "application/json")
    public ResponseEntity<Hotel> obtenerHotelPorNombre(@PathVariable String nombre) {
        Hotel hotel = hotelService.getHotelPorNombre(nombre);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Obtiene un hotel por su ID.
     *
     * @param id el identificador único del hotel a buscar.
     * @return un {@link ResponseEntity} que contiene el objeto {@link Hotel}.
     */
    @GetMapping(value = "/hotel/{id}", produces = "application/json")
    public ResponseEntity<Hotel> obtenerHotelPorId(@PathVariable int id) {
        Hotel hotel = hotelService.getHotelPorId(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

