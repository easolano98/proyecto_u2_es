package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	public void insertar (Estudiante estudiante);
	public void eliminar (Integer numCarnet);
	public Estudiante buscar(Integer numCarnet);
	public void actualizar (Estudiante estudiante);
	
	//Typed 
	public Estudiante buscarPorCarnetTyped(String numCarnet);
	
	public List<Estudiante> buscarPorCarreraApellido(String carrera, String apellido);

	//Named 
	
	public int eliminarPorNombre(String nombre);
	
	public int actualizarCarreraPorCarnet(String carrera,Integer numCarnet);
	
	
	//Typed Named
	public List<Estudiante> buscarApellidoOrden(String apellido);
	
	public List<Estudiante> buscarPorLetra(String letra);

	
	
}
