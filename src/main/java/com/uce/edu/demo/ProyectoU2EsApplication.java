package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetoone.Habitacion;
import com.uce.edu.demo.repository.modelo.onetoone.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel hotel1=new Hotel();
		hotel1.setNombre("Hilton Colon Guy");
		hotel1.setDireccion("Malecon");
		
		
		
		this.hotelService.insertar(hotel1);
		Hotel hote=new Hotel();
		hote.setId(1);
		
		Habitacion habit1=new Habitacion();
		habit1.setNumero("A234");
		habit1.setPiso("10");
		habit1.setTipo("Familiar");
		habit1.setHotel(hote);
		this.habitacionService.insertar(habit1);
		
		Habitacion habit2=new Habitacion();
		habit2.setNumero("A234");
		habit2.setPiso("1");
		habit2.setTipo("Matrimonial");
		habit2.setHotel(hote);
		this.habitacionService.insertar(habit2);
		
	}
}
