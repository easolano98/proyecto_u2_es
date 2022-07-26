package com.uce.edu.demo.debermtm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.debermtm.repository.modelo.LibroAutor;
@Repository
@Transactional
public class LibroAutorRepositoryImpl implements ILibroAutorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(LibroAutor libroAutor) {
		// TODO Auto-generated method stub
	
		this.entityManager.persist(libroAutor);
		
	}

	@Override
	public LibroAutor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(LibroAutor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		LibroAutor libroAuto=this.buscar(id);
		this.entityManager.remove(libroAuto);
	}

	@Override
	public void actualizar(LibroAutor libroAutor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libroAutor);
	}

}
