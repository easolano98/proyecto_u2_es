package com.uce.edu.demo.debermtm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.debermtm.repository.ILibroDeberRepository;
import com.uce.edu.demo.debermtm.repository.modelo.LibroDeber;

@Service
public class LibroDeberServiceImpl implements ILibroDeberService {
	
	@Autowired
	private ILibroDeberRepository deberRepository;
	
	@Override
	public void insertar(LibroDeber libro) {
		// TODO Auto-generated method stub
		this.deberRepository.insertar(libro);
	}

	@Override
	public LibroDeber buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.deberRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.deberRepository.eliminar(id);
	}

	@Override
	public void actualizar(LibroDeber libro) {
		// TODO Auto-generated method stub
		this.deberRepository.actualizar(libro);
	}

	@Override
	public LibroDeber buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.deberRepository.buscarPorTitulo(titulo);
	}

}
