package com.uce.edu.demo.debermtm.service;

import com.uce.edu.demo.debermtm.repository.modelo.LibroDeber;

public interface ILibroDeberService {
	public void insertar (LibroDeber libro);
	
	public LibroDeber buscar (Integer id);
	
	public void eliminar (Integer id);
	
	public void actualizar (LibroDeber libro);
	
	public LibroDeber buscarPorTitulo (String titulo);
}
