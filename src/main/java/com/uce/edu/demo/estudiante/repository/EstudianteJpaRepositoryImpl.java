package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;

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
	
	//Typed
	@Override
	public Estudiante buscarPorCarnetTyped(String numCarnet) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.numCarnet = :datoCarnet", Estudiante.class);
		myTypedQuery.setParameter("datoCarnet", numCarnet);
		return myTypedQuery.getSingleResult();
	}
	
	@Override
	public List<Estudiante> buscarPorCarreraApellido(String carrera, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.carrera= :datoCarrera AND e.apellido= :datoApellido", Estudiante.class);
		myTypedQuery.setParameter("datoCarrera", carrera );
		myTypedQuery.setParameter("datoApellido", apellido );
		return myTypedQuery.getResultList();
	}
	
	
	
	//Named
	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Estudiante.eliminarPorNombre");
		myQuery.setParameter("datoNombre", nombre );
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarCarreraPorCarnet(String carrera, Integer numCarnet) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Estudiante.actualizarCarreraPorCarnet");
		myQuery.setParameter("datoCarrera", carrera );
		myQuery.setParameter("datoCarnet", numCarnet );
		return myQuery.executeUpdate();
	}
	
	
	//Typed Named
	@Override
	public List<Estudiante> buscarApellidoOrden(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createNamedQuery("Estudiante.buscarApellidoOrden", Estudiante.class);
		myTypedQuery.setParameter("datoApellido", apellido);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public List<Estudiante> buscarPorLetra(String letra) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorLetra", Estudiante.class);
		myTypedQuery.setParameter("datoLetra", letra);
		return myTypedQuery.getResultList();

	}

	
	
	
	
	
}
