package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	public void guardar(Estudiante estudiante);

	public void eliminar(Integer numCarnet);

	public Estudiante buscarCarnet(Integer numCarnet);

	public void actualizar(Estudiante estudiante);

	// Typed
	public Estudiante buscarPorCarnetTyped(String numCarnet);

	public List<Estudiante> buscarPorCarreraApellido(String carrera, String apellido);

	// Named

	public int eliminarPorNombre(String nombre);

	public int actualizarCarreraPorCarnet(String carrera, Integer numCarnet);

	// Typed Named
	public List<Estudiante> buscarApellidoOrden(String apellido);

	public List<Estudiante> buscarPorLetra(String letra);

}
