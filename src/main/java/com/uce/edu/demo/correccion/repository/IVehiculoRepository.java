package com.uce.edu.demo.correccion.repository;

import com.uce.edu.demo.correccion.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public int eliminar(String placa);
	public Vehiculo buscar(String placa);
	
}
