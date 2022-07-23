package com.uce.edu.demo.pasaporte.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;

@Repository
@Transactional
public class CiudadanoPasaporteRepositoryImpl implements ICiudanoPasaporteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CiudadanoPasaporte ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(CiudadanoPasaporte ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CiudadanoPasaporte ciudadano = this.buscarPorId(id);
		this.entityManager.remove(ciudadano);
	}

	@Override
	public CiudadanoPasaporte buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<CiudadanoPasaporte> myQuery = this.entityManager.createQuery(
				"SELECT cp FROM CiudadanoPasaporte cp WHERE cp.cedula = :datoCedula", CiudadanoPasaporte.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public CiudadanoPasaporte buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CiudadanoPasaporte.class, id);
	}

	@Override
	public int eliminarPorCed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery =this.entityManager.createQuery("DELETE FROM CiudadanoPasaporte cp WHERE cp.cedula= :datoCedula ");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	
	
	
}
