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
		Persona per1=new Persona();
		
		per1.setApellido("Velez");
		per1.setNombre("Marco");
		per1.setCedula("123123123");
		per1.setGenero("M");
		
		//this.jpaService.guardar(per1);
		
		//1 TypedQuery
		Persona perTyped=this.jpaService.buscarPorCedulaTyped("123123123");
		LOGGER.info("Persona Typed"+perTyped);
		
		//2	NamedQuery
		Persona perNamed=this.jpaService.buscarPorCedulaNamed("123123123");
		LOGGER.info("Persona Named"+perNamed);
		
		//3 Typed Named Query
		Persona perTypedNamed=this.jpaService.buscarPorCedulaTypedNamed("123123123");
		LOGGER.info("Persona Typed Named"+perTypedNamed);
		
		//4 Varios named Query
		List<Persona>listaPersona=this.jpaService.buscarPorNombreApellido("Pamela1", "Nogales");
		for(Persona item : listaPersona) {
			LOGGER.info("Persona: "+item);
		}
	}

}
