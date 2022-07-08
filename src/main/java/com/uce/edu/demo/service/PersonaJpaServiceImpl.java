package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
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

}
