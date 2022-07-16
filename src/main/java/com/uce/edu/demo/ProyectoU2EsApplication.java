package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		List<Estudiante> estudCriteriaLista=this.estudianteJpaService.buscarPorRangos(1, 4, "Medicina");
		for(Estudiante estuCriteria: estudCriteriaLista) {
			LOGGER.info("Estudiantes por rango "+estuCriteria);
			
		}
		
		
		List<Estudiante> estudCriteriaLista2=this.estudianteJpaService.buscarPorApellido("Sea", "Medicina");
		for(Estudiante estuCriteria: estudCriteriaLista2) {
			LOGGER.info("Estudiantes por apellido "+estuCriteria);
			
		}
	}
}
