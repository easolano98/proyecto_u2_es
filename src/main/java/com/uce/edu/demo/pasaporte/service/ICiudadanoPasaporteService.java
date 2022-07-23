package com.uce.edu.demo.pasaporte.service;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;

public interface ICiudadanoPasaporteService {
	
	public void insertar(CiudadanoPasaporte ciudadano);

	public void actualizar(CiudadanoPasaporte ciudadano );
	
	public void eliminar (Integer id);
	
	public CiudadanoPasaporte buscar (String cedula);

	public int eliminarPorCed (String cedula);

}
