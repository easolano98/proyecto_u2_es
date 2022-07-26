package com.uce.edu.demo.debermtm.repository;

import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;

public interface IAutorDeberRepository {
	
	public void insertar (AutorDeber autor);
	
	public AutorDeber buscar (Integer id);
	
	public void eliminar (Integer id);
	
	public void actualizar (AutorDeber autor);
	
	public AutorDeber buscarPorNombre (String nombre);
	
	
}
