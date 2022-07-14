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
		// TODO Auto-generated method stub
		// Named Native
		Estudiante estud = this.estudianteJpaService.buscarPorCedulaNative("1000253003");
		LOGGER.info("Consulta por cedula NamedNative " + estud);

		List<Estudiante> listaEstudianteLetraNamedNative = this.estudianteJpaService.buscarPorLetraNative("So%");
		for (Estudiante item : listaEstudianteLetraNamedNative) {
			LOGGER.info("Buscando apellido que empiece con So Named Native " + item);
		}
		
		//Native
		List<Estudiante> listaEstudianteCarreraNamedNative = this.estudianteJpaService.buscarPorCarreraOrdenarPorNombre("Medicina");
		for (Estudiante item : listaEstudianteCarreraNamedNative) {
			LOGGER.info("Buscando por carrera Native" + item);
		}
		
		Estudiante estud2 = this.estudianteJpaService.buscarPorApellidoNombre("Solano", "Erick");
		LOGGER.info("Consulta por Apellido y Nombre NamedNative " + estud2);

		
	}

}
