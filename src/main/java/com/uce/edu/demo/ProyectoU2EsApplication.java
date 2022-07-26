package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;
import com.uce.edu.demo.debermtm.repository.modelo.LibroAutor;
import com.uce.edu.demo.debermtm.repository.modelo.LibroDeber;
import com.uce.edu.demo.debermtm.service.IAutorDeberService;
import com.uce.edu.demo.debermtm.service.ILibroAutorService;
import com.uce.edu.demo.debermtm.service.ILibroDeberService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IAutorDeberService autorDeberService;

	@Autowired
	private ILibroAutorService libroAutorService;

	@Autowired
	private ILibroDeberService libroDeberService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar

		AutorDeber autor1 = new AutorDeber();
		autor1.setNombre("Julio Berne");	
		this.autorDeberService.insertar(autor1);
		
		AutorDeber autor2= new AutorDeber();
		autor2.setNombre("Juanito Peralta ");	
		this.autorDeberService.insertar(autor2);
		
		AutorDeber autor3= new AutorDeber();
		autor3.setNombre("Miguel Cervantes ");	
		this.autorDeberService.insertar(autor3);
		
		
		LibroDeber libro1 = new LibroDeber();
		libro1.setTitulo("Don quijote de la mancha");
		libro1.setCantidadPaginas(300);
		this.libroDeberService.insertar(libro1);
		
		LibroDeber libro2 = new LibroDeber();
		libro2.setTitulo("El principito");
		libro2.setCantidadPaginas(300);
		this.libroDeberService.insertar(libro2);
		
		LibroDeber libro3 = new LibroDeber();
		libro3.setTitulo("Viaje al centro de la tierra");
		libro3.setCantidadPaginas(300);
		this.libroDeberService.insertar(libro3);
		
		
		LibroAutor autorLibro1 = new LibroAutor();
		
		autorLibro1.setAutor(autor1);
		autorLibro1.setLibro(libro1);
		this.libroAutorService.insertar(autorLibro1);
		
		LibroAutor autorLibro2 = new LibroAutor();
		
		autorLibro2.setAutor(autor2);
		autorLibro2.setLibro(libro1);
		this.libroAutorService.insertar(autorLibro2);
		
		LibroAutor autorLibro3 = new LibroAutor();
		
		autorLibro3.setAutor(autor3);
		autorLibro3.setLibro(libro2);
		this.libroAutorService.insertar(autorLibro3);
		
		LibroAutor autorLibro4 = new LibroAutor();
		
		autorLibro4.setAutor(autor3);
		autorLibro4.setLibro(libro3);
		this.libroAutorService.insertar(autorLibro4);
		
		
		
		
	}
}
