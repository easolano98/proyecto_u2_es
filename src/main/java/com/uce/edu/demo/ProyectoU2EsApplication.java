package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner{
	@Autowired
	private IPersonaJdbcService jdbcService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProyectoU2EsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Persona persona=new Persona();
		persona.setId(3);
		persona.setNombre("Teodoro");
		persona.setApellido("Casa");
		//Insertar
		//this.jdbcService.guardar(persona);
		
		Persona persona1=new Persona();
		persona1.setId(2);
		persona1.setNombre("Pepito");
		persona1.setApellido("Velez");
		
		//Actualizar
		//this.jdbcService.actualizar(persona1);
	
		//Borrar
		//this.jdbcService.eliminar(2);
		
		//Buscar
		Persona per=this.jdbcService.buscarPorId(3);
		LOGGER.info(null);
	}

}
