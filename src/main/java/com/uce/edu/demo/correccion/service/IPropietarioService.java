package com.uce.edu.demo.correccion.service;

import com.uce.edu.demo.correccion.repository.modelo.Propietario;

public interface IPropietarioService {
	public void crear(Propietario propietario);
	public void eliminar(String cedula);
}
