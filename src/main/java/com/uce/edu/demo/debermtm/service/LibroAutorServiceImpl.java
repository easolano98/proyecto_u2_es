package com.uce.edu.demo.debermtm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.debermtm.repository.ILibroAutorRepository;
import com.uce.edu.demo.debermtm.repository.modelo.LibroAutor;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService {
	
	@Autowired
	private ILibroAutorRepository autorRepository;
	
	
	
	@Override
	public void insertar(LibroAutor libroAutor) {
		// TODO Auto-generated method stub
		
		this.autorRepository.insertar(libroAutor);
		
	}

	@Override
	public LibroAutor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
	}

	@Override
	public void actualizar(LibroAutor libroAutor) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(libroAutor);
	}

}
