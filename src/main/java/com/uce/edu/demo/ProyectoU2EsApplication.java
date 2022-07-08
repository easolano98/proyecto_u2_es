package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IPersonaJpaService jpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		

		Persona per = new Persona();
		per.setNombre("Omar");
		per.setApellido("Tipan");
		per.setCedula("1752301000");
		per.setGenero("M");

		 //GUARDAR
//		 this.jpaService.guardar(per);
		
		//Buscar por Cedula
		LOGGER.info(this.jpaService.buscarPorCedula("0520220"));
		
		LOGGER.info("/////////////////////////Buscar por Apellido//////////////////////////////////");
		//Buscar por Apellido
		List<Persona>listaPersonaApellido=this.jpaService.buscarApellido("Nogales");
		for(Persona item : listaPersonaApellido) {
			LOGGER.info("Persona por apellido: "+item);
		}
		
		LOGGER.info("////////////////////////Buscar por Nombre///////////////////////////////////");
		//Buscar por Nombre
		List<Persona>listaPersonaNombre=this.jpaService.buscarNombre("Lucho");
		for(Persona item : listaPersonaNombre) {
			LOGGER.info("Persona por nombre "+item);
		}
		
		LOGGER.info("////////////////////////Buscar por Genero///////////////////////////////////");
		//Buscar por Genero
		List<Persona>listaPersonaGenero=this.jpaService.buscarGenero("M");
		for(Persona item : listaPersonaGenero) {
			LOGGER.info("Persona por genero "+item);
		}
		
		
		// ACTUALIZAR
		//this.jpaService.actualizar(per1);

		// ELIMINAR
		//this.jpaService.eliminar(7);

	}

}
