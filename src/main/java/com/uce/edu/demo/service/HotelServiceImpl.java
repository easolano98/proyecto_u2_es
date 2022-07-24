package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHabitacionRepository;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Habitacion> habitaciones = hotel.getHabitaciones();
		hotel.setHabitaciones(null);

		this.hotelRepository.insertar(hotel);

		// Buscar el hotel
		String numero = hotel.getNombre(); 
		Hotel hotelBuscar = null;
		for (Habitacion habiItem : habitaciones) {
			habiItem.setHotel(hotelBuscar);
			this.habitacionRepository.insertar(habiItem);
		}
	}

}
