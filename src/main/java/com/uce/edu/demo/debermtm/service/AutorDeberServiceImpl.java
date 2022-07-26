package com.uce.edu.demo.debermtm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.debermtm.repository.IAutorDeberRepository;
import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;

@Service
public class AutorDeberServiceImpl implements IAutorDeberService {

	@Autowired
	private IAutorDeberRepository autorDeberRepository;

	@Override
	public void insertar(AutorDeber autor) {
		// TODO Auto-generated method stub
		this.autorDeberRepository.insertar(autor);
	}

	@Override
	public AutorDeber buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorDeberRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.autorDeberRepository.eliminar(id);
	}

	@Override
	public void actualizar(AutorDeber autor) {
		// TODO Auto-generated method stub
		this.autorDeberRepository.actualizar(autor);
	}

	@Override
	public AutorDeber buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub

		return this.autorDeberRepository.buscarPorNombre(nombre);
	}

}
