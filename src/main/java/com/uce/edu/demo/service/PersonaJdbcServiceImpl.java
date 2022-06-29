package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;
@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {
	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;
	
	@Override
	public void guardar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.insertar(persona);
	}

	@Override
	public void actualizar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.personaJdbcRepository.eliminar(id);
	}

	@Override
	public PersonaTo buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.personaJdbcRepository.buscarPorId(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.personaJdbcRepository.buscarTodos();
	}

}
