package com.uce.edu.demo;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante=new Estudiante();
		estudiante.setNumCarnet(2);
		estudiante.setCedula("1723050613");
		estudiante.setNombre("Josue");
		estudiante.setApellido("Espinel");
		estudiante.setCarrera("Odontologia");
		
		//Insertar
		this.estudianteJdbcService.ingresar(estudiante);
		
		Estudiante estudiante1=new Estudiante();
		estudiante1.setNumCarnet(4);
		estudiante1.setCedula("1750015205");
		estudiante1.setNombre("Erick");
		estudiante1.setApellido("Solano");
		estudiante1.setCarrera("Arquitectura");
		
		//Actualizar
		this.estudianteJdbcService.actualizar(estudiante1);
		
		//Borrar
		this.estudianteJdbcService.borrar("1720220405");
		
		//Buscar
		Estudiante estd=this.estudianteJdbcService.buscar(4);
		
		LOGGER.info(estd);
	}

}
