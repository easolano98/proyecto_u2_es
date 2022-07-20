package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;
@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudanoRepository{
	

	@PersistenceContext
	private EntityManager entityManager;// punto de acceso a la BD
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
		
	}

}
