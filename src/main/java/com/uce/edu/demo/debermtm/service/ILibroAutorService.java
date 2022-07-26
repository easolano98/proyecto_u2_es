package com.uce.edu.demo.debermtm.service;

import com.uce.edu.demo.debermtm.repository.modelo.LibroAutor;

public interface ILibroAutorService {
	
	public void insertar (LibroAutor libroAutor);
	
	public LibroAutor buscar (Integer id);
	
	public void eliminar (Integer id );
	
	public void actualizar (LibroAutor libroAutor);
	
	
}
