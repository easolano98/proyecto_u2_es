package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	public void insertar (Estudiante estudiante);
	public void eliminar (Integer numCarnet);
	public Estudiante buscar(Integer numCarnet);
	public void actualizar (Estudiante estudiante);
}
