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
		Estudiante estudiante1=new Estudiante();
		
		estudiante1.setNombre("Alexander");
		estudiante1.setApellido("Simba");
		estudiante1.setCedula("90010253003");
		estudiante1.setNumCarnet(6);
		estudiante1.setCarrera("Turismo");
		
		this.estudianteJpaService.guardar(estudiante1);
		
		//Typed
		Estudiante estuTyped=this.estudianteJpaService.buscarCarnet(1);
		LOGGER.info("*Estudiante Carnet "+estuTyped);
		
		List<Estudiante>estuTyped2=this.estudianteJpaService.buscarPorCarreraApellido("Medicina", "Soria");
		for(Estudiante item :estuTyped2 ) {
			LOGGER.info("Buscando por carrera y apellido "+item);
		}
		
		//Named
		int borrados=this.estudianteJpaService.eliminarPorNombre("Alexander");
		LOGGER.info("Borrados "+borrados);
		
		int actualizados=this.estudianteJpaService.actualizarCarreraPorCarnet("Veterinaria", 4);
		LOGGER.info("Actualizados "+actualizados);
		
		//Typed Named
		List<Estudiante>listaEstudiante=this.estudianteJpaService.buscarApellidoOrden("Sea");
		for(Estudiante item : listaEstudiante) {
			LOGGER.info(item);
		}
		
		List<Estudiante>listaEstudianteLetra=this.estudianteJpaService.buscarPorLetra("So%");
		for(Estudiante item : listaEstudianteLetra) {
			LOGGER.info("Buscando apellido que empiece con So "+item);
		}

	}

}
