package com.uce.edu.demo.estudiante.repository;

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

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudiantePromedioEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

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
		Estudiante estudiante = this.buscar(numCarnet);
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

	// Typed
	@Override
	public Estudiante buscarPorCarnetTyped(String numCarnet) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.numCarnet = :datoCarnet", Estudiante.class);
		myTypedQuery.setParameter("datoCarnet", numCarnet);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorCarreraApellido(String carrera, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.carrera= :datoCarrera AND e.apellido= :datoApellido",
				Estudiante.class);
		myTypedQuery.setParameter("datoCarrera", carrera);
		myTypedQuery.setParameter("datoApellido", apellido);
		return myTypedQuery.getResultList();
	}

	// Named
	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.eliminarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarCarreraPorCarnet(String carrera, Integer numCarnet) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.actualizarCarreraPorCarnet");
		myQuery.setParameter("datoCarrera", carrera);
		myQuery.setParameter("datoCarnet", numCarnet);
		return myQuery.executeUpdate();
	}

	// Typed Named
	@Override
	public List<Estudiante> buscarApellidoOrden(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createNamedQuery("Estudiante.buscarApellidoOrden",
				Estudiante.class);
		myTypedQuery.setParameter("datoApellido", apellido);
		return myTypedQuery.getResultList();

	}

	@Override
	public List<Estudiante> buscarPorLetra(String letra) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorLetra",
				Estudiante.class);
		myTypedQuery.setParameter("datoLetra", letra);
		return myTypedQuery.getResultList();

	}

	// Named Native
	@Override
	public Estudiante buscarPorCedulaNative(String numCedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQueryNamedNative = this.entityManager
				.createNamedQuery("Estudiante.buscarPorCedulaNative", Estudiante.class);
		myQueryNamedNative.setParameter("datoCedula", numCedula);
		return myQueryNamedNative.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorLetraNative(String letra) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQueryNamedNative = this.entityManager
				.createNamedQuery("Estudiante.buscarPorLetraNative", Estudiante.class);
		myQueryNamedNative.setParameter("datoLetra", letra);
		return myQueryNamedNative.getResultList();
	}

	// Native
	@Override
	public List<Estudiante> buscarPorCarreraOrdenarPorNombre(String carrera) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_carrera= :datoCarrera ORDER BY estu_nombre ", Estudiante.class);
		myNamedQuery.setParameter("datoCarrera", carrera);
		return myNamedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorApellidoNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_apellido= :datoApellido AND estu_nombre= :datoNombre ",
				Estudiante.class);
		myNamedQuery.setParameter("datoApellido", apellido);
		myNamedQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myNamedQuery.getSingleResult();
	}

	// Consultar si es respecto a la carrera de medicina los rangos se apliquen para
	// el id del estudiante, caso contrario se apliquen para el numero del carnet
	@Override
	public List<Estudiante> buscarPorRangos(Integer inicio, Integer fin, String carrera) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoFinal = null;
		if (carrera.equals("Medicina")) {
			predicadoFinal = myCriteria.between(myTabla.get("id"), inicio, fin);

		} else {
			predicadoFinal = myCriteria.between(myTabla.get("numCarnet"), inicio, fin);
		}

		myQuery.select(myTabla).where(predicadoFinal);

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	// Consultar el apellido de un estudiante, y que si es carrera de medicina la
	// lista ordene de forma ascencente
	// caso contrario se ordene de forma descendente
	@Override
	public List<Estudiante> buscarPorApellido(String apellido, String carrera) {
		// TODO Auto-generated method stub

		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);
		Predicate buscarCedula = myCriteria.equal(myTabla.get("apellido"), apellido);

		if (carrera.equals("Medicina")) {
			myQuery.select(myTabla).where(buscarCedula).orderBy(myCriteria.asc(myTabla.get("id")));

		} else {
			myQuery.select(myTabla).where(buscarCedula).orderBy(myCriteria.desc(myTabla.get("id")));

		}

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	// Consulta con Objetos Sencillos
	// Consultar por letra y ordenar de forma descendente
	@Override
	public List<EstudianteSencillo> buscarPorLetraYOrdenarSencillo(String letra) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo(e.apellido, e.cedula, e.id) FROM Estudiante e WHERE e.apellido LIKE :datoLetra ORDER BY e.id DESC",
				EstudianteSencillo.class);
		myQuery.setParameter("datoLetra", letra);
		return myQuery.getResultList();
	}

	// Consultar el promedio de las edades de los estudiantes por carrera
	@Override
	public List<EstudiantePromedioEdad> buscarEdadPromedioPorCarrera() {
		// TODO Auto-generated method stub
		TypedQuery<EstudiantePromedioEdad> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.estudiante.repository.modelo.EstudianteContador(e.carrera, AVG(e.edad)) FROM Estudiante e GROUP BY e.carrera ORDER BY e.carrera ASC",
				EstudiantePromedioEdad.class);

		return myQuery.getResultList();
	}

}
