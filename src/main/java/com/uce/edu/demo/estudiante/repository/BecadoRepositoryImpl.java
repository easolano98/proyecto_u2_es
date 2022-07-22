package com.uce.edu.demo.estudiante.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository ;

import com.uce.edu.demo.estudiante.repository.modelo.Becado;

@Repository
@Transactional
public class BecadoRepositoryImpl implements IBecadoRepository {
	

	@PersistenceContext
	private EntityManager entityManager;// punto de acceso a la BD
	
	@Override
	public void insertar(Becado becado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(becado);
	}	
	
}
