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
		
	Persona per	=this.jpaService.buscarPorCedulaNative("123123123");
	LOGGER.info("persona Native-----> "+per);	
	
	Persona per2=this.jpaService.buscarPorCedulaNamedNative("123123123");
	LOGGER.info("persona NativeNamed-----> "+per2);	
		
	}

}
