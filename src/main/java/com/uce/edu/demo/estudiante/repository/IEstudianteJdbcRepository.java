package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcRepository {

	public void insertar(EstudianteTo e);

	public EstudianteTo buscar(int numCarnet);

	public void actualizar(EstudianteTo e);

	public void eliminar(String cedula);
}
