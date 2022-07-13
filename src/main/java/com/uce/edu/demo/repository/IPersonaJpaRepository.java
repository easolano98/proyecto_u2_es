package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {
	public Persona buscarPorId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarApellido(String apellido);

	public List<Persona> buscarNombre(String nombre);

	public List<Persona> buscarGenero(String genero);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);

	// Typed
	public Persona buscarPorCedulaTyped(String cedula);

	// Named
	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);

	// Native Query
	public Persona buscarPorCedulaNative(String cedula);

	// Native Named Query
	public Persona buscarPorCedulaNamedNative(String cedula);

	// Criteria API Query
	public Persona buscarPorCedulaCriteriaApi(String cedula);

}
