package com.uce.edu.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);
	
	@Autowired
	private ILibroService iLibroService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insertar
		

		Autor autor1=new Autor();
		autor1.setNombre("Alexander");
		Set<Autor> autores=new HashSet<>();
		autores.add(autor1);
		
		Libro libro1=new Libro();
		libro1.setTitulo("Viaje al centro de la tierra");
		libro1.setCantidadPaginas(300);
		libro1.setAutores(autores);
		
		this.iLibroService.insertar(libro1);
	}
}
