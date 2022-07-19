package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudiantePromedioEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

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

	// Named Native

	public Estudiante buscarPorCedulaNative(String numCedula);

	public List<Estudiante> buscarPorLetraNative(String letra);

	// Native

	public List<Estudiante> buscarPorCarreraOrdenarPorNombre(String carrera);

	public Estudiante buscarPorApellidoNombre(String apellido, String nombre);
	
	//Criteria API Query
	
		public List <Estudiante> buscarPorRangos(Integer inicio, Integer fin, String carrera );
		
		public List <Estudiante> buscarPorApellido(String apellido, String carrera);
		
//Consulta objeto sencillo
		public List <EstudianteSencillo> buscarPorLetraSencillo(String letra);

		public List<EstudiantePromedioEdad> buscarEdadPromedioPorCarrera();
}
