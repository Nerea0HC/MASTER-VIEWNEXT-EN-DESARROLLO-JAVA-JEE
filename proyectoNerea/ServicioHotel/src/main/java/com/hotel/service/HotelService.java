package com.hotel.service;

import java.util.List;
import com.hotel.model.Hotel;

public interface HotelService {
    List<Hotel> getHotelesDisponibles();
    Hotel getHotelPorNombre(String nombre);
}
