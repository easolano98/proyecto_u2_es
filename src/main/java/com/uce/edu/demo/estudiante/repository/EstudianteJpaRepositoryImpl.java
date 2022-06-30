package com.uce.edu.demo.estudiante.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void eliminar(Integer numCarnet) {
		// TODO Auto-generated method stub
		Estudiante estudiante=this.buscar(numCarnet);
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante buscar(Integer numCarnet) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, numCarnet);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

}
