package com.uce.edu.demo;

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

		//LOGGER.info(this.jpaService.buscarPorId(3));

		Persona per = new Persona();
		//per.setId(3);
		per.setNombre("Pamela1");
		per.setApellido("Nogales");

		// GUARDAR
		 this.jpaService.guardar(per);

		Persona per1=new Persona();
		per1.setId(8);
		per1.setNombre("Wilsona");
		per1.setApellido("Tipantaxi");
		
		
		// ACTUALIZAR
		//this.jpaService.actualizar(per1);

		// ELIMINAR
		//this.jpaService.eliminar(3);

	}

}
