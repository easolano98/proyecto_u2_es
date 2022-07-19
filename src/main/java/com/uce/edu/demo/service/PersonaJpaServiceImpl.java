package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {
	@Autowired
	private IPersonaJpaRepository jpaRepository;
	
	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorId(id);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.jpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.jpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.jpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarApellido(apellido);
	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarNombre(nombre);
	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarGenero(genero);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.jpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.jpaRepository.eliminarPorGenero(genero);
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}

	@Override
	public List<PersonaSencilla> buscarPorApellidoSencilla(String apellido) {
		// TODO Auto-generated method stub
		return this.jpaRepository.buscarPorApellidoSencilla(apellido);
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		return this.jpaRepository.consultarCantidadPorGenero();
	}
	
	

}
