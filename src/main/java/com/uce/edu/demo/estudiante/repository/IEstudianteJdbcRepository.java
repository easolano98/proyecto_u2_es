package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public void insertar(Estudiante e);

	public Estudiante buscar(int numCarnet);

	public void actualizar(Estudiante e);

	public void eliminar(String cedula);
}
