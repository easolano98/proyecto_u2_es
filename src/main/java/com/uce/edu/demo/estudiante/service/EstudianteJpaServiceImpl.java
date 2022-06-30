package com.uce.edu.demo.estudiante.service;

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

}
