package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.estudiante.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{
	@Autowired
	private IEstudianteJdbcRepository jdbcRepository;
	
	@Override
	public void ingresar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcRepository.insertar(e);
	}

	@Override
	public Estudiante buscar(int numCarnet) {
		// TODO Auto-generated method stub
		return this.jdbcRepository.buscar(numCarnet);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcRepository.actualizar(e);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.jdbcRepository.eliminar(cedula);
		
	}

}
