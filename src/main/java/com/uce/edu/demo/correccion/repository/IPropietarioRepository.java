package com.uce.edu.demo.correccion.repository;

import com.uce.edu.demo.correccion.repository.modelo.Propietario;

public interface IPropietarioRepository {
	public void crear(Propietario propietario);
	public int eliminar(String cedula);
	public Propietario consultar(String cedula);

	
}
