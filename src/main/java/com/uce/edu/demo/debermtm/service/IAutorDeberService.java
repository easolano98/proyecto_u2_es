package com.uce.edu.demo.debermtm.service;

import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;

public interface IAutorDeberService {
	
	public void insertar (AutorDeber autor);
	
	public AutorDeber buscar (Integer id);
	
	public void eliminar (Integer id);
	
	public void actualizar (AutorDeber autor);
	
	public AutorDeber buscarPorNombre(String nombre);
	
}
