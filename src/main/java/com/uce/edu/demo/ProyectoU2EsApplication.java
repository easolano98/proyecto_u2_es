package com.uce.edu.demo;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);
	
	
	@Autowired 
	private IEstudianteJpaService estudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Buscar
		LOGGER.info(this.estudianteJpaService.buscarCarnet(1));
	
		Estudiante estudiante=new Estudiante();
		estudiante.setNumCarnet(5);
		estudiante.setCedula("0720131021");
		estudiante.setNombre("Janineth");
		estudiante.setApellido("Iza");
		estudiante.setCarrera("Medicina");
		
		//Guardar
		this.estudianteJpaService.guardar(estudiante);
		
		Estudiante estudiante1=new Estudiante();
		estudiante1.setNumCarnet(3);
		estudiante1.setCedula("0506152022");
		estudiante1.setNombre("Leonardo");
		estudiante1.setApellido("Simbaña");
		estudiante1.setCarrera("Ingenieria Civil");
		//Actualizar
		this.estudianteJpaService.actualizar(estudiante1);
		//Eliminar
		this.estudianteJpaService.eliminar(2);
		
		
		
	}

}
