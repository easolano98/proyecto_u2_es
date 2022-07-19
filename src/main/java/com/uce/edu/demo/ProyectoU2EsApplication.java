package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

		List<PersonaSencilla>listaPersona=this.jpaService.buscarPorApellidoSencilla("Nogales");
		for(PersonaSencilla perItem:listaPersona) {
			LOGGER.info("Persona Sencilla "+perItem );
		}
		
		List<PersonaContadorGenero>listaPersonaGenero=this.jpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero perItem:listaPersonaGenero) {
			LOGGER.info("Persona Sencilla "+perItem );
		}
	}
}
