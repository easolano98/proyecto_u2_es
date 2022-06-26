package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProyectoU2EsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("HOLA MUNDO");
	}

}
