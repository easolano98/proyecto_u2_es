package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	public Persona buscarPorId(Integer id);

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarApellido(String apellido);

	public List<Persona> buscarNombre(String nombre);

	public List<Persona> buscarGenero(String genero);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

	// Typed
	public Persona buscarPorCedulaTyped(String cedula);

	// Named
	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);

	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);

	// Native Query
	public Persona buscarPorCedulaNative(String cedula);

	// Native Named Query
	public Persona buscarPorCedulaNamedNative(String cedula);

}
