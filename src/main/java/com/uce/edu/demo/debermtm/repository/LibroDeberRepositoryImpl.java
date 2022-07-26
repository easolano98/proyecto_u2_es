package com.uce.edu.demo.debermtm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;
import com.uce.edu.demo.debermtm.repository.modelo.LibroDeber;
@Repository
@Transactional
public class LibroDeberRepositoryImpl implements ILibroDeberRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(LibroDeber libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public LibroDeber buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(LibroDeber.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		LibroDeber libro=this.buscar(id);
		this.entityManager.remove(libro);
		
	}

	@Override
	public void actualizar(LibroDeber libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public LibroDeber buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<LibroDeber>query=this.entityManager.createQuery("SELECT l FROM LibroDeber l WHERE l.titulo=: datoNombre", LibroDeber.class);
		query.setParameter("datoNombre", titulo);
		return query.getSingleResult();
	}

	
	
	
	
	
}
