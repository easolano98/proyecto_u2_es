package com.uce.edu.demo.correccion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correccion.repository.modelo.Propietario;
@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	
	}

	@Override
	public int eliminar(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE FROM Propietario p WHERE p.cedula= :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula= :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Propietario) myQuery.getSingleResult();
	}
	
}
