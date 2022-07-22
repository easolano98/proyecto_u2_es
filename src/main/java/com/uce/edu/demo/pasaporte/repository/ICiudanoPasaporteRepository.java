package com.uce.edu.demo.pasaporte.repository;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;

public interface ICiudanoPasaporteRepository {
	
	public void insertar(CiudadanoPasaporte ciudadano);

	public void actualizar(CiudadanoPasaporte ciudadano );
	
	public void eliminar (Integer id);
	
	public CiudadanoPasaporte buscarPorId (Integer id);
	
	public CiudadanoPasaporte buscar (String cedula);
}
