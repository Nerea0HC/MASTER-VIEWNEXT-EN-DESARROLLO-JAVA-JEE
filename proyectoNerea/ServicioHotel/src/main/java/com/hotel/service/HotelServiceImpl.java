package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getHotelesDisponibles() {
        return hotelRepository.findByDisponibleTrue();
    }

    @Override
    public Hotel getHotelPorNombre(String nombre) {
        return hotelRepository.findByNombre(nombre);
    }

    @Override
    public Hotel getHotelPorId(int id) {
        return hotelRepository.findById(id).orElse(null);
    }
}
