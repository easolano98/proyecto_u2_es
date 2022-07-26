package com.uce.edu.demo.debermtm.repository;

import com.uce.edu.demo.debermtm.repository.modelo.LibroAutor;

public interface ILibroAutorRepository {
	
	public void insertar (LibroAutor libroAutor);
	
	public LibroAutor buscar (Integer id);
	
	public void eliminar (Integer id );
	
	public void actualizar (LibroAutor libroAutor);
}
