package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.EstudiantePromedioEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IEstudianteJpaService jpaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		
		List<EstudianteSencillo>listaEstudiantesPorLetra=this.jpaService.buscarPorLetraSencillo("S%");
		for(EstudianteSencillo perItem:listaEstudiantesPorLetra) {
			LOGGER.info("Estudiante Sencillo que empiecen con SOR "+perItem );
		}
		
		
		List<EstudiantePromedioEdad>listaEstudiantesEdadPromedio=this.jpaService.buscarEdadPromedioPorCarrera();
		for(EstudiantePromedioEdad perItem:listaEstudiantesEdadPromedio) {
			LOGGER.info("Promedio de la edad de los estudiantes por carrera "+perItem );
		}
		
	}
}
