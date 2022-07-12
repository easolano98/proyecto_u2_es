package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {
	
	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void eliminar(Integer numCarnet) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(numCarnet);
	}

	@Override
	public Estudiante buscarCarnet(Integer numCarnet) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscar(numCarnet);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscarPorCarnetTyped(String numCarnet) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCarnetTyped(numCarnet);
	}

	@Override
	public List<Estudiante> buscarPorCarreraApellido(String carrera, String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCarreraApellido(carrera, apellido);
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.eliminarPorNombre(nombre);
	}

	@Override
	public int actualizarCarreraPorCarnet(String carrera, Integer numCarnet) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.actualizarCarreraPorCarnet(carrera, numCarnet);
	}

	@Override
	public List<Estudiante> buscarApellidoOrden(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarApellidoOrden(apellido);
	}

	@Override
	public List<Estudiante> buscarPorLetra(String letra) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorLetra(letra);
	}

}
