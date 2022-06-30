package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	public void guardar (Estudiante estudiante);
	public void eliminar (Integer numCarnet);
	public Estudiante buscarCarnet(Integer numCarnet);
	public void actualizar (Estudiante estudiante);
}
