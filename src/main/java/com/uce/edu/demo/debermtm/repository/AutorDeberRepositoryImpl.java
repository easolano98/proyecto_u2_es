package com.uce.edu.demo.debermtm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.debermtm.repository.modelo.AutorDeber;
@Repository
@Transactional
public class AutorDeberRepositoryImpl implements IAutorDeberRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(AutorDeber autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public AutorDeber buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(AutorDeber.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public void actualizar(AutorDeber autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public AutorDeber buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<AutorDeber>query=this.entityManager.createQuery("SELECT a FROM AutorDeber a WHERE a.nombre=: datoNombre", AutorDeber.class);
		query.setParameter("datoNombre", nombre);
		return query.getSingleResult();
	}

	
}
