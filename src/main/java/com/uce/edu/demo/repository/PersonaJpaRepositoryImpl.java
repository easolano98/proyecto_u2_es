package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Repository
@Transactional

public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;// punto de acceso a la BD

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);

	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);

		return (Persona) jpqlQuery.getSingleResult();// Este devuelve un objeto de tipo persona;
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		jpqlQuery.setParameter("datoApellido", apellido);

		return jpqlQuery.getResultList();

	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre= :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return jpqlQuery.getResultList();
	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero= :datoGenero");
		jpqlQuery.setParameter("datoGenero", genero);
		return jpqlQuery.getResultList();

	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero = :datoGenero ");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.executeUpdate();
	}

	// Consultas Typed

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	// Consultas Named
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	// Consultas Named Typed
	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myTypedQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula",
				Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getResultList();
	}

	// Native
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula= :datoCedula ",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	// Named Native
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	// Criteria API Query
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub

		// creamos una instancia de la interfaz CriteriaBuilder Fabrica para construir
		// el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		// especificamos el retorno del SQL
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		// Aqui empezamos a construir el sql
		// Root FROM-> Root Tabla principal
		Root<Persona> personaFrom = myQuery.from(Persona.class);
		// myQuery.select(personaFrom);//Select p From Persona
		// Las condiciones where en criteria API se los conoce como predicados
		Predicate p1 = myBuilder.equal(personaFrom.get("cedula"), cedula);

		CriteriaQuery<Persona> myQuieryCompleto = myQuery.select(personaFrom).where(p1);
		// Finalizado mi quiery completo

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuieryCompleto);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);
		// pers_nombre='Maria'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		// pers_apellido='Iza'
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		// Hace una and entre esos 2 predicados
		
		Predicate miPredicadoFinal=null;
		if (genero.equals("M")) {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);

		} else {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTabla).where(miPredicadoFinal);

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);
		// pers_nombre='Maria'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		// pers_apellido='Iza'
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		// Hace una and entre esos 2 predicados
		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);

		
		Predicate miPredicadoFinal=null;
		if (genero.equals("M")) {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido, predicadoGenero);
			miPredicadoFinal=myCriteria.and(miPredicadoFinal, predicadoGenero);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido, predicadoGenero);
			miPredicadoFinal=myCriteria.and(miPredicadoFinal, predicadoGenero);

		}
		myQuery.select(myTabla).where(miPredicadoFinal);

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}
// De forma sencilla

	@Override
	public List<PersonaSencilla> buscarPorApellidoSencilla(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<PersonaSencilla> myQuery= this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre, p.apellido) FROM Persona p WHERE p.apellido= :datoApellido",PersonaSencilla.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		//SELECT pers_genero, COUNT (pers_genero) FROM persona GROUP BY pers_genero 	
		TypedQuery<PersonaContadorGenero>myQuery= this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero (p.genero, COUNT(p.genero)) FROM Persona p GROUP BY p.genero",PersonaContadorGenero.class);

		return myQuery.getResultList();
	}
	
}
